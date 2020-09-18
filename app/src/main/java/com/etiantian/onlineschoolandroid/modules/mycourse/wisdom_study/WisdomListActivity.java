package com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.etiantian.lib_network.request.RequestParams;
import com.etiantian.lib_network.response_handler.NormalResponseCallBack;
import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.api.NetworkManager;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.MyCourseSubjectModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.subject_detail.MaterialModel;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.test.BaseListViewAdapter;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.test.NodeBean;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.test.TreeViewDataSource;
import com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study.test.TreeViewNode;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class WisdomListActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private MyCourseSubjectModel.DataBean subjectDetailModel;
    private MaterialModel.DataBean materialVersionModel;
    private WisdomModel wisdomModel;

    private static final String TAG = WisdomListActivity.class.getSimpleName();
    private static final int NODE_MARGIN_LEFT = 12;//px
    private int mCurrExpandIndex;
    private String mCurrExpandOrgId;
    private NodeBean mNodeBean;
    private ListView mListView;
    private ListViewAdapter adapter;
    private TreeViewDataSource dataSource;
    final String[][] CITY = new String[][]{{"南京","苏州","无锡"},{"济南","青岛","日照"},{"杭州","宁波","温州"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisdom_list);
        Intent intent = getIntent();
        if (intent != null) {
            String subjectDetailJson = intent.getStringExtra("subjectDetailModel");
            String materialVersionJson = intent.getStringExtra("materialVersionModel");
            MyCourseSubjectModel.DataBean dataBean = new Gson().fromJson(subjectDetailJson,MyCourseSubjectModel.DataBean.class);
            MaterialModel.DataBean material = new Gson().fromJson(materialVersionJson,MaterialModel.DataBean.class);
            this.subjectDetailModel = dataBean;
            this.materialVersionModel = material;
            Log.d("1","传递过来的数据:"+ dataBean.getSubjectName());
            fetchWisdomList();
        }
    }

    /// 获取智慧学习列表
    private void fetchWisdomList() {
        RequestParams params = new RequestParams();
        params.put("materialId", String.valueOf(materialVersionModel.getDefMaterialId()));
        NetworkManager.wisdomListFetch(params, new NormalResponseCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                WisdomModel wisdomModel = (WisdomModel) responseObj;
                initData(wisdomModel);
                Log.d("1","获取智慧学习列表成功");
            }

            @Override
            public void onFailure(Object responseObj) {
                Log.d("1","获取智慧学习列表失败");
            }
        });
    }

    public static int dp2px(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    ///
    /// 章下面有resourceIdList,表示存在本章复习,级别和nodeList一致
    /// 节下面有resourceIdList,表示存在本节复习,级别和nodeList一致
    ///
    private void initData(WisdomModel wisdomModel) {
        List<TreeViewNode> list = new ArrayList<>();
        for (int i = 0; i < wisdomModel.getData().size(); i++) {
            WisdomModel.DataBean dataBean = wisdomModel.getData().get(i);
            /// 根节点 章
            TreeViewNode<WisdomModel.DataBean> rootNode = new TreeViewNode<>();
            rootNode.data = dataBean;
            if (dataBean.getLevel() == 1) {
                /// 添加正常节
                for (int j = 0; j < dataBean.getNodeList().size(); j++) {
                    addNormalChildNode(rootNode, dataBean.getNodeList(), false);
                }

                /// 添加本章复习
//                for (int j = 0; j < dataBean.getResourceIdList().size(); j++) {
//                    addNormalChildNode(rootNode, dataBean.getNodeList(), false);
//                }
            }


            list.add(rootNode);
        }

        dataSource = new TreeViewDataSource(list);

        initView();
    }

    /// 添加正常节点
    public void addNormalChildNode(TreeViewNode rootNode, List<WisdomModel.DataBean.NodeListBean> dataBeans, boolean isLeaf) {
        if (dataBeans != null && dataBeans.size() > 0) {
            if(rootNode.child != null) {
                rootNode.child.clear();
            } else {
                rootNode.child = new ArrayList<TreeViewNode>();
            }
            for (int i = 0; i < dataBeans.size(); i++) {
                TreeViewNode childNode = new TreeViewNode<>();
                WisdomModel.DataBean.NodeListBean nodeBean = dataBeans.get(i);
                childNode.data = nodeBean;
                childNode.isLeaf = isLeaf;
                childNode.maginLeft = dp2px(this,NODE_MARGIN_LEFT) + rootNode.maginLeft;
                rootNode.child.add(childNode);
                if (nodeBean.getLevel() == 3) {

                }
                addNormalChildNode(childNode, nodeBean.getNodeList(), isLeaf);
            }
        }

    }

    /// 添加本章复习子节点
    public void addCurrentChapterChildNode(TreeViewNode<WisdomModel.DataBean> rootNode, List<WisdomModel.DataBean.NodeListBean> dataBeans, boolean isLeaf) {

//        if(rootNode.child == null) {
//            rootNode.child = new ArrayList<TreeViewNode>();
//        }
//
//        for(WisdomModel.DataBean.NodeListBeanX dataBean:dataBeans) {
//            TreeViewNode<WisdomModel.DataBean.NodeListBeanX> childNode = new TreeViewNode<>();
//            childNode.data = dataBean;
//            childNode.isLeaf = isLeaf;
//            childNode.maginLeft = dp2px(this,NODE_MARGIN_LEFT) + rootNode.maginLeft;
//            rootNode.child.add(childNode);
//        }
    }

    private void initView() {
        mListView=findViewById(R.id.organization_listview);
        mListView.setOnItemClickListener(this);
        adapter = new ListViewAdapter();
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
            View view = LayoutInflater.from(WisdomListActivity.this).inflate(R.layout.item_org_tree, parent, false);
            TreeViewHolder holder = new TreeViewHolder(view);
            return holder;
        }

        @Override
        protected void onBindViewHolder(BaseListViewHolder holder, final int position) {
            TreeViewNode node = (TreeViewNode) getItem(position);
            TreeViewHolder treeViewHolder = (TreeViewHolder) holder;
            if(!node.isLeaf) {
                treeViewHolder.ivSelected.setVisibility(View.INVISIBLE);
                treeViewHolder.ivExpand.setVisibility(View.VISIBLE);
                //NodeBean nodeBean =  node.data;
                Object dataBean = node.data;
                String title = "";
                if (dataBean.getClass() == WisdomModel.DataBean.class) {
                    WisdomModel.DataBean bean = (WisdomModel.DataBean) dataBean;
                    title = bean.getNodeName();
                } else if (dataBean.getClass() == WisdomModel.DataBean.NodeListBean.class) {
                    WisdomModel.DataBean.NodeListBean nodeListBeanX = (WisdomModel.DataBean.NodeListBean)dataBean;
                    title = nodeListBeanX.getNodeName();
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
                //NodeBean nodeBean =  node.data;
                Object dataBean = node.data;
                String title = "";
                if (dataBean.getClass() == WisdomModel.DataBean.class) {
                    WisdomModel.DataBean bean = (WisdomModel.DataBean) dataBean;
                    title = bean.getNodeName();
                } else if (dataBean.getClass() == WisdomModel.DataBean.NodeListBean.class) {
                    WisdomModel.DataBean.NodeListBean nodeListBeanX = (WisdomModel.DataBean.NodeListBean)dataBean;
                    title = nodeListBeanX.getNodeName();
                }
                treeViewHolder.textView.setText(title);

                //是否选中开关
                if (node.isSelected) {
                    treeViewHolder.ivSelected.setImageDrawable(getResources().getDrawable((R.drawable.ic_org_tree_item_selected)));
                } else {
                    treeViewHolder.ivSelected.setImageDrawable(getResources().getDrawable((R.drawable.ic_org_tree_item_unselect)));
                }

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

    class TreeViewHolder extends BaseListViewAdapter.BaseListViewHolder {

        public TextView textView;
        public ImageView ivSelected;
        public ImageView ivExpand;

        public TreeViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv);
            ivSelected = (ImageView) itemView.findViewById(R.id.iv_selected);
            ivExpand = (ImageView) itemView.findViewById(R.id.iv_expand);
        }
    }
}