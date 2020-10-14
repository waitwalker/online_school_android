package com.etiantian.onlineschoolandroid.modules.mycourse.ai_test;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.common_tools.CommonWebViewActivity;
import com.etiantian.onlineschoolandroid.modules.common_tools.VideoPlayActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.MyCourseSubjectModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.change_material.ChangeMaterialVersionActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.subject_detail.MaterialModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.subject_detail.ResourceInfoModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.MicroCourseModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.WisdomListActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.WisdomModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.expanded_tree.BaseListViewAdapter;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.expanded_tree.NodeBean;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.expanded_tree.TreeViewDataSource;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.expanded_tree.TreeViewNode;
import com.google.gson.Gson;
import com.jaeger.library.StatusBarUtil;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AITestListActivity extends BaseActivity implements AdapterView.OnItemClickListener, CompoundButton.OnClickListener {

    private MyCourseSubjectModel.DataBean subjectDetailModel;
    private MaterialModel.DataBean materialVersionModel;
    private String gradeId;
    private WisdomModel wisdomModel;

    private static final String TAG = WisdomListActivity.class.getSimpleName();
    private static final int NODE_MARGIN_LEFT = 12;//px
    private int mCurrExpandIndex;
    private String mCurrExpandOrgId;
    private NodeBean mNodeBean;
    private ListView mListView;
    private AITestListActivity.ListViewAdapter adapter;
    private TreeViewDataSource dataSource;

    private ViewGroup backButton;
    private ViewGroup navigationBar;
    private TextView back_button;
    private CommonTitleBar commonTitleBar;
    private Button knowledgeButton;
    private ViewGroup changeMaterialVersionContainer;
    private TextView materialVersionTextView;
    private Long courseId;
    private boolean isZhiLing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_test_list);
        hideActionBar();
        initActionBar();
        Intent intent = getIntent();
        if (intent != null) {
            hud.show();
            String subjectDetailJson = intent.getStringExtra("subjectDetailModel");
            String materialVersionJson = intent.getStringExtra("materialVersionModel");
            MyCourseSubjectModel.DataBean dataBean = new Gson().fromJson(subjectDetailJson,MyCourseSubjectModel.DataBean.class);
            MaterialModel.DataBean material = new Gson().fromJson(materialVersionJson,MaterialModel.DataBean.class);
            courseId = intent.getLongExtra("courseId", 0);
            isZhiLing = intent.getBooleanExtra("isZhiLing", false);
            this.subjectDetailModel = dataBean;
            this.materialVersionModel = material;
            this.gradeId = intent.getStringExtra("gradeId");
            Log.d("1","传递过来的数据:"+ dataBean.getSubjectName());
            fetchAITestList();
            knowledgeButton.setVisibility(View.INVISIBLE);
            initChangeMaterialVersion();
        }
    }

    ///
    /// @description actionBar
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/29 9:09 AM
    ///
    private void initActionBar() {
        hideActionBar();
        navigationBar = findViewById(R.id.navigation_bar);
        navigationBar.setBackgroundColor(Color.parseColor("#5FACEF"));
        commonTitleBar = findViewById(R.id.actionbar);
        commonTitleBar.setBackgroundColor(Color.parseColor("#5FACEF"));
        StatusBarUtil.setColor(AITestListActivity.this, Color.parseColor("#5FACEF"));

        backButton = findViewById(R.id.back_container);
        backButton.setOnClickListener(this);
        back_button = findViewById(R.id.action_bar_title);
        back_button.setText("AI测试");
        back_button.setTextColor(Color.WHITE);
        back_button.setOnClickListener(this);

        knowledgeButton = findViewById(R.id.right_button);
        knowledgeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_container:
            case R.id.action_bar_title:
                finish();
                break;
            case R.id.right_button:
                Log.d("1","点击了知识导学按钮");
                break;
            case R.id.change_material_version_container:
                Intent intent = new Intent(this, ChangeMaterialVersionActivity.class);
                intent.putExtra("subjectId", String.valueOf(subjectDetailModel.getSubjectId()));
                intent.putExtra("gradeId", gradeId);
                startActivity(intent);
                break;
        }
    }

    /// 初始化切换教材
    private void initChangeMaterialVersion() {
        changeMaterialVersionContainer = findViewById(R.id.change_material_version_container);
        materialVersionTextView = findViewById(R.id.material_title_text);
        materialVersionTextView.setText(materialVersionModel.getDefAbbreviation() + " · " + materialVersionModel.getDefMaterialName());
        changeMaterialVersionContainer.setOnClickListener(this);
    }

    /// 获取智慧学习列表
    private void fetchAITestList() {
        RequestParams params = new RequestParams();
        params.put("materialId", String.valueOf(materialVersionModel.getDefMaterialId()));
        NetworkManager.aiTestListFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                AITestModel aiTestModel = (AITestModel) responseObj;
                initData(aiTestModel);
                Log.d("1","获取AI测试列表成功");
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","获取AI测试列表失败");
                hud.dismiss();
            }
        });
    }

    public static int dp2px(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    private void initData(AITestModel aiTestModel) {
        List dataList = new ArrayList();
        for (int i = 0; i < aiTestModel.getData().size(); i++) {
            AITestModel.DataBean dataBean = aiTestModel.getData().get(i);
            dataList.add(dataBean);
        }
        Log.d("1","1");
        initDataSource((ArrayList) dataList);
    }

    ///
    /// 章下面有resourceIdList,表示存在本章复习,级别和nodeList一致
    /// 节下面有resourceIdList,表示存在本节复习,级别和nodeList一致
    ///
    private void initDataSource(ArrayList dataS) {
        List<TreeViewNode> list = new ArrayList<>();
        for (int i = 0; i < dataS.size(); i++) {
            AITestModel.DataBean dataBean = (AITestModel.DataBean)dataS.get(i);
            /// 根节点 章
            TreeViewNode<AITestModel.DataBean> rootNode = new TreeViewNode<>();
            rootNode.data = dataBean;
            for (int j = 0; j < dataBean.getChapterList().size(); j++) {
                addNormalChildNode(rootNode, dataBean.getChapterList(), (dataBean.getChapterList() == null || dataBean.getChapterList().size() == 0));
            }
            list.add(rootNode);
        }

        dataSource = new TreeViewDataSource(list);
        initView();
        hud.dismiss();
    }

    /// 添加正常节点
    public void addNormalChildNode(TreeViewNode rootNode, List dataBeans, boolean isLeaf) {
        if (dataBeans != null && dataBeans.size() > 0) {
            if(rootNode.child != null) {
                rootNode.child.clear();
            } else {
                rootNode.child = new ArrayList<TreeViewNode>();
            }

            for (int i = 0; i < dataBeans.size(); i++) {
                TreeViewNode childNode = new TreeViewNode<>();
                Object nodeBean = dataBeans.get(i);
                if (nodeBean.getClass() == AITestModel.DataBean.ChapterListBean.class) {
                    AITestModel.DataBean.ChapterListBean tmpBean = (AITestModel.DataBean.ChapterListBean)nodeBean;
                    Log.d("1","节点名称:"+ tmpBean.getChapterName());
                    childNode.data = tmpBean;
                    childNode.isLeaf = tmpBean.getChapterList().size() == 0;
                    childNode.maginLeft = dp2px(this,NODE_MARGIN_LEFT) + rootNode.maginLeft;
                    rootNode.child.add(childNode);
                    if (tmpBean.getChapterList() !=null && tmpBean.getChapterList().size() > 0) {
                        Log.d("1","class类型:"+ tmpBean.getClass());
                        addNormalChildNode(childNode, tmpBean.getChapterList(), tmpBean.getChapterList().size() == 0);
                    }
                } else {
                    Log.d("1","class类型:"+ nodeBean.getClass());
                    Log.d("1", "nodeBean:" + nodeBean);
                    AITestModel.DataBean tmpBean = (AITestModel.DataBean)nodeBean;
                    Log.d("1","节点名称:"+ tmpBean.getChapterName());
                    childNode.data = tmpBean;
                    childNode.isLeaf = true;
                    childNode.maginLeft = dp2px(this,NODE_MARGIN_LEFT) + rootNode.maginLeft;
                    rootNode.child.add(childNode);
                }
            }
        } else {

        }

    }
    private void initView() {
        mListView=findViewById(R.id.organization_listview);
        mListView.setOnItemClickListener(this);
        adapter = new AITestListActivity.ListViewAdapter();
        mListView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TreeViewNode node =  dataSource.getElements().get(position);
        if (node.isLeaf) {
            node.isSelected = !node.isSelected;//节点状态变化
            adapter.notifyItemChanged(mListView, position);
        } else {
            node.isExpand = !node.isExpand;
            dataSource.updateNodes();//节点数量变化
            adapter.notifyDataSetChanged();
        }
    }

    class ListViewAdapter extends BaseListViewAdapter<BaseListViewAdapter.BaseListViewHolder> {

        @Override
        protected BaseListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(AITestListActivity.this).inflate(R.layout.item_org_tree, parent, false);
            AITestListActivity.TreeViewHolder holder = new AITestListActivity.TreeViewHolder(view);
            return holder;
        }

        @Override
        protected void onBindViewHolder(BaseListViewHolder holder, final int position) {
            TreeViewNode node = (TreeViewNode) getItem(position);
            AITestListActivity.TreeViewHolder treeViewHolder = (AITestListActivity.TreeViewHolder) holder;
            if(!node.isLeaf) {
                treeViewHolder.ivSelected.setVisibility(View.INVISIBLE);
                treeViewHolder.ivExpand.setVisibility(View.VISIBLE);
                treeViewHolder.resourceTypeText.setVisibility(View.INVISIBLE);
                //NodeBean nodeBean =  node.data;
                Object dataBean = node.data;
                String title = "";
                if (dataBean.getClass() == AITestModel.DataBean.class) {
                    AITestModel.DataBean bean = (AITestModel.DataBean) dataBean;
                    title = bean.getChapterName();
                } else if (dataBean.getClass() == AITestModel.DataBean.ChapterListBean.class) {
                    AITestModel.DataBean.ChapterListBean nodeListBeanX = (AITestModel.DataBean.ChapterListBean)dataBean;
                    title = nodeListBeanX.getChapterName();
                }

                treeViewHolder.textView.setText(title);

                //是否展开
                if (node.isExpand) {
                    treeViewHolder.ivExpand.setImageDrawable(getResources().getDrawable((R.drawable.ic_org_expanded)));
                } else {
                    treeViewHolder.ivExpand.setImageDrawable(getResources().getDrawable((R.drawable.ic_org_unexpand)));
                }
            } else {
                treeViewHolder.ivExpand.setVisibility(View.INVISIBLE);
                treeViewHolder.ivSelected.setVisibility(View.VISIBLE);
                treeViewHolder.resourceTypeText.setVisibility(View.VISIBLE);
                //NodeBean nodeBean =  node.data;
                Object dataBean = node.data;
                String title = "";
                String resourceType = "";
                if (dataBean.getClass() == AITestModel.DataBean.class) {
                    AITestModel.DataBean bean = (AITestModel.DataBean) dataBean;
                    title = bean.getChapterName();
                    if (node.isLeaf) {
                        final AITestModel.DataBean resourceIdListBean = (AITestModel.DataBean)dataBean;
                        title = resourceIdListBean.getChapterName();

                        resourceType = String.valueOf(resourceIdListBean.getScore());

                        //是否选中开关
//                    if (resourceIdListBean.getStudyStatus() == 1) {
//                        treeViewHolder.ivSelected.setImageDrawable(getResources().getDrawable((R.drawable.ic_org_tree_item_selected)));
//                    } else {
//                        treeViewHolder.ivSelected.setImageDrawable(getResources().getDrawable((R.drawable.ic_org_tree_item_unselect)));
//                    }

                        treeViewHolder.resourceTypeText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(AITestListActivity.this, CommonWebViewActivity.class);
                                String url = NetworkManager.HttpConstants.AI_Test_Html_URL +
                                        "&versionid=" + materialVersionModel.getDefMaterialId() +
                                        "&subjectid=" + materialVersionModel.getSubjectId() +
                                        "&currentdirid=" + resourceIdListBean.getChapterId() +
                                        "&courseid=" + courseId;
                                intent.putExtra("url", url);
                                intent.putExtra("title", resourceIdListBean.getChapterName());
                                intent.putExtra("showAnswerCard", false);
                                startActivity(intent);
                            }
                        });
                    }
                } else if (dataBean.getClass() == AITestModel.DataBean.ChapterListBean.class) {
                    AITestModel.DataBean.ChapterListBean nodeListBeanX = (AITestModel.DataBean.ChapterListBean)dataBean;
                    title = nodeListBeanX.getChapterName();

                    Log.d("1","是否树叶:" + node.isLeaf);
                }
                treeViewHolder.textView.setText(title);
                treeViewHolder.resourceTypeText.setText(resourceType);
            }
            treeViewHolder.itemView.setPadding(node.maginLeft, 0, 0, 0);
        }

        @Override
        public int getCount() {
            int count = dataSource.getElements().size();
            return count;
        }

        @Override
        public Object getItem(int position) {
            return dataSource.getElements().get(position);
        }
    }

    ///
    /// @description 获取微课数据
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/10/12 2:14 PM
    ///
    private void fetchMicroCourse(RequestParams params) {
        NetworkManager.microCourseFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                MicroCourseModel microCourseModel = (MicroCourseModel) responseObj;
                Log.d("1","获取微课视频数据成功");
                Intent intent = new Intent(AITestListActivity.this, VideoPlayActivity.class);
                String json = new Gson().toJson(microCourseModel);
                intent.putExtra("microCourseModel", json);
                startActivity(intent);
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","获取资源信息数据失败");
            }
        });
    }

    ///
    /// @description 获取资源信息数据
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/10/12 2:14 PM
    ///
    private void fetchResourceInfo(RequestParams params) {
        NetworkManager.resourceInfoFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                ResourceInfoModel resourceInfoModel = (ResourceInfoModel) responseObj;
                Log.d("1","获取资源信息数据成功");
                Intent intent = new Intent(AITestListActivity.this, CommonWebViewActivity.class);
                String url = resourceInfoModel.getData().getLiteraturePreviewUrl();
                intent.putExtra("url", url);
                intent.putExtra("title", resourceInfoModel.getData().getResourceName());
                startActivity(intent);
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","获取微课视频数据失败");
            }
        });
    }

    class TreeViewHolder extends BaseListViewAdapter.BaseListViewHolder {

        public ViewGroup container;
        public TextView textView;
        public ImageView ivSelected;
        public ImageView ivExpand;
        public TextView resourceTypeText;

        public TreeViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.wisdom_item_relative);
            textView = (TextView) itemView.findViewById(R.id.tv);
            ivSelected = (ImageView) itemView.findViewById(R.id.iv_selected);
            ivExpand = (ImageView) itemView.findViewById(R.id.iv_expand);
            resourceTypeText = (TextView) itemView.findViewById(R.id.resource_type);
        }
    }
}