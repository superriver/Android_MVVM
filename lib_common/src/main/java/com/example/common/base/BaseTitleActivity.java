package com.example.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.common.R;



/**
 * Created by laimengfu on 2016/10/20.
 *
 * @
 */
public class BaseTitleActivity extends BaseActivity {

    private LinearLayout llParent;
    private LayoutInflater mInflater;
    private View contentView;

    //title
    private View titleView;
    private RelativeLayout rlTitle;
    private LinearLayout llLeft;
    private LinearLayout llRight;
    private ImageView ivLeft;
    private ImageView ivRight;
    private TextView tvLeft;
    private TextView tvRight;
    private TextView tvTitle;
    private View titleDivider;
    private View statusBarFix;
    private View titleBg;

    //error
    private ImageView ivError;
    private TextView tvErrorReminder;
    private TextView tvRetry;
    private SparseArray<View> errorViews = new SparseArray<>();

    public TextView getTvErrorReminder() {
        return tvErrorReminder;
    }

    public TextView getTvRetry() {
        return tvRetry;
    }

    public ImageView getIvError() {
        return ivError;
    }

    public ImageView getIvLeft() {
        return ivLeft;
    }

    public ImageView getIvRight() {
        return ivRight;
    }

    public TextView getTvLeft() {
        return tvLeft;
    }

    public TextView getTvRight() {
        return tvRight;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public LinearLayout getLlRight() {
        return llRight;
    }


    public LinearLayout getLlLeft() {
        return llLeft;
    }
    public View getTitleView() {
        return titleView;
    }

    public View getTitleDivider() {
        return titleDivider;
    }

    public View getStatusBarFix() {
        return statusBarFix;
    }

    public View getTitleBg() {
        return titleBg;
    }
    public RelativeLayout getRlTitle() {
        return rlTitle;
    }

    public void showTitleDivider() {
        titleDivider.setVisibility(View.VISIBLE);
    }

    public void hideTitleDivider() {
        titleDivider.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInflater = LayoutInflater.from(this);

    }

    /**
     * 加载含有base title的布局
     *
     * @param contentView
     */
    protected void initContentView(View contentView) {
        this.contentView = contentView;
        setContentView(R.layout.base_layout);
        llParent = (LinearLayout) findViewById(R.id.ll_parent);
        titleView = mInflater.inflate(R.layout.base_title_layout, null);
        llParent.addView(titleView);
        llParent.addView(contentView);
        initTitleView();
        initTitleEvent();

    }

    /**
     * 加载含有base title的布局
     *
     * @param resLayoutId
     */
    protected void initContentView(int resLayoutId) {
        View contentView = mInflater.inflate(resLayoutId, (ViewGroup) getWindow().getDecorView(), false);
        initContentView(contentView);
    }


    /**
     * 加载含有base title的布局
     *
     * @param contentView
     * @param isAddTitle
     * @param isShowTitle
     */
    protected void initContentView(View contentView, boolean isAddTitle, boolean isShowTitle) {
        this.contentView = contentView;
        setContentView(R.layout.base_layout);
        llParent = (LinearLayout) findViewById(R.id.ll_parent);
        if (isAddTitle) {
            titleView = mInflater.inflate(R.layout.base_title_layout, null);
            llParent.addView(titleView);
            initTitleView();
            initTitleEvent();
        }
        llParent.addView(contentView);

        if (isAddTitle && titleView != null) {
            if (isShowTitle) {
                titleView.setVisibility(View.VISIBLE);
            } else {
                titleView.setVisibility(View.GONE);
            }
        }


    }

    /**
     * 加载含有base title的布局
     *
     * @param resLayoutId
     * @param isAddTitle
     * @param isShowTitle
     */
    protected void initContentView(int resLayoutId, boolean isAddTitle, boolean isShowTitle) {
        View contentView = mInflater.inflate(resLayoutId, (ViewGroup) getWindow().getDecorView(), false);
        initContentView(contentView, isAddTitle, isShowTitle);
    }

    /**
     * 加载自定义title的布局
     *
     * @param titleView
     * @param contentView
     */
    protected void initCustomTitleAndContentView(View titleView, View contentView) {
        this.titleView = titleView;
        this.contentView = contentView;
        setContentView(R.layout.base_layout);
        llParent = (LinearLayout) findViewById(R.id.ll_parent);
        llParent.addView(titleView);
        llParent.addView(contentView);
    }

    /**
     * 加载自定义title的布局
     *
     * @param resTitleLayoutId
     * @param resContentLayoutId
     */
    protected void initCustomTitleAndContentView(int resTitleLayoutId, int resContentLayoutId) {
        View titleView = mInflater.inflate(resTitleLayoutId, null);
        View contentView = mInflater.inflate(resContentLayoutId, (ViewGroup) getWindow().getDecorView(), false);
        initCustomTitleAndContentView(titleView, contentView);
    }


    /**
     * 加载自定义title的布局
     *
     * @param titleView
     * @param contentView
     * @param isAddTitle
     * @param isShowTitle
     */
    protected void initCustomTitleAndContentView(View titleView, View contentView, boolean isAddTitle, boolean isShowTitle) {
        this.titleView = titleView;
        this.contentView = contentView;
        setContentView(R.layout.base_layout);
        llParent = (LinearLayout) findViewById(R.id.ll_parent);
        if (isAddTitle) {
            llParent.addView(titleView);
        }
        llParent.addView(contentView);
        if (isAddTitle && titleView != null) {
            if (isShowTitle) {
                titleView.setVisibility(View.VISIBLE);
            } else {
                titleView.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 加载自定义title的布局
     *
     * @param resTitleLayoutId
     * @param resContentLayoutId
     * @param isAddTitle
     * @param isShowTitle
     */
    protected void initCustomTitleAndContentView(int resTitleLayoutId, int resContentLayoutId, boolean isAddTitle, boolean isShowTitle) {
        View titleView = null;
        if (isAddTitle) {
            titleView = mInflater.inflate(resTitleLayoutId, null);
        }
        View contentView = mInflater.inflate(resContentLayoutId, (ViewGroup) getWindow().getDecorView(), false);
        initCustomTitleAndContentView(titleView, contentView, isAddTitle, isShowTitle);
    }


    protected void setError() {
        setError(true);
    }

    protected void setError(boolean isShowTitle) {
        llParent.removeAllViews();
        View errorView = errorViews.get(R.layout.base_error_layout);
        if (errorView == null) {
            errorView = mInflater.inflate(R.layout.base_error_layout, llParent, false);
            errorViews.put(R.layout.base_error_layout, errorView);
            if (titleView != null) {
                if (isShowTitle) {
                    llParent.addView(titleView);
                }
            }
            llParent.addView(errorView);
            initErrorView();
            initErrorEvent();
        }
    }


    protected void setCustomError(int errorLayoutResId) {
        View errorView = errorViews.get(errorLayoutResId);
        if (errorView == null) {
            errorView = mInflater.inflate(errorLayoutResId, llParent, false);
            errorViews.put(errorLayoutResId, errorView);
        }
        setCustomError(errorView);
    }

    protected void setCustomError(View errorView) {
        llParent.removeAllViews();
        if (errorView == null) {
            return;
        }
        if (titleView != null) {
            llParent.addView(titleView);
        }
        llParent.addView(errorView);
    }

    protected void setCustomError(int errorLayoutResId, boolean isShowTitle) {
        View errorView = errorViews.get(errorLayoutResId);
        if (errorView == null) {
            errorView = mInflater.inflate(errorLayoutResId, llParent, false);
            errorViews.put(errorLayoutResId, errorView);
        }
        setCustomError(errorView, isShowTitle);
    }

    protected void setCustomError(View errorView, boolean isShowTitle) {
        llParent.removeAllViews();
        if (errorView == null) {
            return;
        }
        if (titleView != null) {
            if (isShowTitle) {
                llParent.addView(titleView);
            }
        }
        llParent.addView(errorView);
    }


    /**
     * 加载base title 可以调用的方法
     *
     * @param resTitleTextId
     */
    protected void setTitleText(int resTitleTextId) {
        tvTitle.setText(resTitleTextId);
    }

    protected void setTitleText(String titleText) {
        tvTitle.setText(titleText);
    }

    protected void setLeftText(int resId) {
        tvLeft.setText(resId);
    }

    protected void setLeftText(String text) {
        tvLeft.setText(text);
    }

    protected void setRightText(int resId) {
        tvRight.setText(resId);
    }

    protected void setRightText(String text) {
        tvRight.setText(text);
    }


    /**
     * 加载base error可以调用的方法
     *
     * @param resId
     */
    protected void setErrorText(int resId) {
        tvErrorReminder.setText(resId);
    }

    protected void setErrorText(String text) {
        tvErrorReminder.setText(text);
    }

    protected void setLeftTitleShow(boolean isShowleftIcon, boolean isShowLeftText) {
        if (isShowleftIcon) {
            ivLeft.setVisibility(View.VISIBLE);
        } else {
            ivLeft.setVisibility(View.GONE);
        }
        if (isShowLeftText) {
            tvLeft.setVisibility(View.VISIBLE);
        } else {
            tvLeft.setVisibility(View.GONE);
        }
    }

    protected void setRightTitleShow(boolean isShowRightIcon, boolean isShowRightText) {
        if (isShowRightIcon) {
            ivRight.setVisibility(View.VISIBLE);
        } else {
            ivRight.setVisibility(View.GONE);
        }
        if (isShowRightText) {
            tvRight.setVisibility(View.VISIBLE);
        } else {
            tvRight.setVisibility(View.GONE);
        }
    }

    protected void setTitleShow(boolean isShowleftIcon, boolean isShowLeftText,
                                boolean isShowRightIcon, boolean isShowRightText) {
        setLeftTitleShow(isShowleftIcon, isShowLeftText);
        setRightTitleShow(isShowRightIcon, isShowRightText);
    }


    protected void hideTitle() {
        if (titleView != null) {
            titleView.setVisibility(View.GONE);
        }
    }

    protected void showTitle() {
        if (titleView != null) {
            titleView.setVisibility(View.VISIBLE);
        }
    }

    private void initTitleView() {
        rlTitle = (RelativeLayout) findViewById(R.id.rl_title);
        llLeft = (LinearLayout) findViewById(R.id.ll_left);
        llRight = (LinearLayout) findViewById(R.id.ll_right);
        ivLeft = (ImageView) findViewById(R.id.iv_left);
        ivRight = (ImageView) findViewById(R.id.iv_right);
        tvLeft = (TextView) findViewById(R.id.tv_left);
        tvRight = (TextView) findViewById(R.id.tv_right);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        titleDivider = findViewById(R.id.title_divider);
        statusBarFix = findViewById(R.id.status_bar_fix);
        titleBg = findViewById(R.id.bg);
    }

    private void initErrorView() {
        ivError = (ImageView) findViewById(R.id.iv_error);
        tvErrorReminder = (TextView) findViewById(R.id.tv_error_reminder);
        tvRetry = (TextView) findViewById(R.id.tv_retry);
    }

    private void initTitleEvent() {
        llLeft.setOnClickListener(clickListener);
        llRight.setOnClickListener(clickListener);
    }

    private void initErrorEvent() {
        tvRetry.setOnClickListener(clickListener);
    }

    /**
     * 加载base title会调用的方法
     */
    protected void leftClickEvent() {
        finish();
    }

    /**
     * 加载base title会调用的方法
     */
    protected void rightClickEvent() {

    }

    /**
     * 加载base error会调用的方法
     */
    protected void errorRetryEvent() {

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int viewId = v.getId();
            if (viewId == R.id.ll_left) {
                leftClickEvent();
            } else if (viewId == R.id.ll_right) {
                rightClickEvent();
            } else if (viewId == R.id.tv_retry) {
                errorRetryEvent();
            }
        }
    };

    protected void onErrorRetryFail() {

    }

    protected void onErrorRetrySuccess() {
        onErrorRetrySuccess(true);
    }

    protected void onErrorRetrySuccess(boolean isShowTitle) {
        llParent.removeAllViews();
        if (titleView != null) {
            if (isShowTitle) {
                llParent.addView(titleView);
            }
        }
        if (contentView != null) {
            llParent.addView(contentView);
        }
    }

}
