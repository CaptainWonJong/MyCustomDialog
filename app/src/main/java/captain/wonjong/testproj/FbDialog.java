package captain.wonjong.testproj;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FbDialog implements View.OnClickListener {
    private static FbDialog uniqueInstance = new FbDialog();

    private Dialog               mDialog;
    private Context              mContext;

    private ImageView            mIvTopImage;
    private TextView             mTvTitle;
    private TextView             mTvContent;

    private LinearLayout         mLlCheckBox;
    private CheckBox             mCheckBox;
    private TextView             mTvCheckBoxText;

    private Button               mBtnSub;
    private Button               mBtnLeft;
    private View                 mViewBtnLine;
    private Button               mBtnRight;

    public static FbDialog getInstance() {
        return uniqueInstance;
    }

    public FbDialog showDialog(@NonNull Context context, String title, String content, boolean isLeftBtnVisible) {
        mContext = context;

        mDialog = new Dialog(mContext, android.R.style.Theme_Translucent_NoTitleBar);
        mDialog.setCancelable(false);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.setContentView(R.layout.my_dialog);

        initView();
        setData(title, content,null, isLeftBtnVisible);

        try {
            mDialog.show();
        } catch (Exception e) {
            mDialog = null;
        }

        return getInstance();
    }

    public FbDialog showDialog(@NonNull Context context, String title, String content, Object topImageUrl, boolean isLeftBtnVisible) {
        mContext = context;

        mDialog = new Dialog(mContext, android.R.style.Theme_Translucent_NoTitleBar);
        mDialog.setCancelable(false);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.setContentView(R.layout.my_dialog);

        initView();
        setData(title, content, topImageUrl, isLeftBtnVisible);

        try {
            mDialog.show();
        } catch (Exception e) {
            mDialog = null;
        }

        return getInstance();
    }

    private void initView() {
        mIvTopImage = (ImageView) mDialog.findViewById(R.id.iv_common_dialog_top_image);
        mTvTitle = (TextView) mDialog.findViewById(R.id.tv_common_dialog_title);
        mTvContent = (TextView) mDialog.findViewById(R.id.tv_common_dialog_content);
        mLlCheckBox = (LinearLayout) mDialog.findViewById(R.id.ll_common_dialog_checkbox);
        mCheckBox = (CheckBox) mDialog.findViewById(R.id.cb_common_dialog_checkbox);
        mTvCheckBoxText = (TextView) mDialog.findViewById(R.id.tv_common_dialog_checkbox_text);
        mBtnSub = (Button) mDialog.findViewById(R.id.btn_common_dialog_sub);
        mBtnLeft = (Button) mDialog.findViewById(R.id.btn_common_dialog_left);
        mBtnRight = (Button) mDialog.findViewById(R.id.btn_common_dialog_right);
        mViewBtnLine = (View) mDialog.findViewById(R.id.v_common_dialog_bottom_boundary_line);

        mIvTopImage.setVisibility(View.GONE);
        mTvTitle.setVisibility(View.GONE);
        mTvContent.setVisibility(View.GONE);
        mLlCheckBox.setVisibility(View.GONE);
        mBtnSub.setVisibility(View.GONE);
        mBtnLeft.setVisibility(View.GONE);
        mViewBtnLine.setVisibility(View.GONE);
    }

    private void setData(String title, String content, Object topImageUrl, boolean isLeftBtnVisible) {
        setImageView(mIvTopImage, topImageUrl);
        setTextView(mTvTitle, title);
        setTextView(mTvContent, content);
        setBottomButtonType(isLeftBtnVisible);
    }

    /**
     * @param checkBoxText
     * @return
     */
    public FbDialog setCheckBox(String checkBoxText) {
        mLlCheckBox.setVisibility(View.VISIBLE);
        mCheckBox.setVisibility(View.VISIBLE);
        mTvCheckBoxText.setText(checkBoxText);
        return getInstance();
    }

    /**
     * @param leftBtnText
     * @param onLeftBtnClickListener
     * @return
     */
    public FbDialog setLeftBtnOnClickListener(String leftBtnText, View.OnClickListener onLeftBtnClickListener) {
        setBtnOnClickListener(mBtnLeft, leftBtnText, onLeftBtnClickListener);
        mViewBtnLine.setVisibility(mBtnLeft.getVisibility());
        return getInstance();
    }

    /**
     * @param rightBtnText
     * @param onRightBtnClickListener
     * @return
     */
    public FbDialog setRightBtnOnClickListener(String rightBtnText, View.OnClickListener onRightBtnClickListener) {
        setBtnOnClickListener(mBtnRight, rightBtnText, onRightBtnClickListener);
        return getInstance();
    }

    /**
     * @param subBtnText
     * @param onSubBtnClickListener
     * @return
     */
    public FbDialog setSubBtnOnClickListener(String subBtnText, View.OnClickListener onSubBtnClickListener) {
        setBtnOnClickListener(mBtnSub, subBtnText, onSubBtnClickListener);
        return getInstance();
    }

    public boolean isChecked() {
        return mCheckBox.isChecked();
    }

    public void setChecked(boolean checked) {
        mCheckBox.setChecked(checked);
    }

    public boolean isShow() {
        return (mDialog != null && mDialog.isShowing()) ? true : false;
    }

    public void show() {
        if (mDialog != null) {
            mDialog.show();
        }
    }

    public void dismiss() {
        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }

    private void setImageView(ImageView imageView, Object topImageUrl) {
        if (topImageUrl != null) {
            imageView.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(topImageUrl).into(imageView);
        }
    }

    private void setTextView(TextView textView, String text) {
        if (TextUtils.isEmpty(text)) {
            textView.setVisibility(View.GONE);
        } else {
            textView.setVisibility(View.VISIBLE);
            textView.setText(Html.fromHtml(text));
        }
    }

    private void setBottomButtonType(boolean isLeftBtnVisible) {
        mBtnRight.setText(mContext.getString(R.string.ok));
        mBtnRight.setVisibility(View.VISIBLE);
        mBtnRight.setOnClickListener(this);

        if (isLeftBtnVisible) {
            mBtnLeft.setText(mContext.getString(R.string.cancel));
            mBtnLeft.setVisibility(View.VISIBLE);
            mViewBtnLine.setVisibility(View.VISIBLE);
            mBtnLeft.setOnClickListener(this);

        } else {
            mBtnLeft.setVisibility(View.GONE);
            mViewBtnLine.setVisibility(View.GONE);
        }
    }

    private void setBtnOnClickListener(Button btn, String text, View.OnClickListener onClickListener) {
        btn.setVisibility(View.VISIBLE);
        btn.setText(text);
        btn.setOnClickListener((onClickListener == null) ? this : onClickListener);
    }

    public void setNegativeClick(View.OnClickListener negativeClickListener) {
        setLeftBtnOnClickListener(mContext.getString(R.string.cancel), negativeClickListener);
    }

    public void setNegativeClick(String strBtnText, View.OnClickListener negativeClickListener) {
        setLeftBtnOnClickListener(strBtnText, negativeClickListener);
    }

    public void setPositiveClick(View.OnClickListener positiveListener) {
        setRightBtnOnClickListener(mContext.getString(R.string.ok), positiveListener);
    }

    public void setPositiveClick(String strBtnText, View.OnClickListener positiveListener) {
        setRightBtnOnClickListener(strBtnText, positiveListener);
    }
}
