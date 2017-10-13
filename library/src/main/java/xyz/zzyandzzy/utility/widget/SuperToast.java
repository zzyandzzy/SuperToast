package xyz.zzyandzzy.utility.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.CheckResult;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import xyz.zzyandzzy.utility.R;

public class SuperToast {
    private Context mContext;

    private static Toast mToast;

    private View mParentView;
    private CardView mCardView;
    private ImageView mImageView;
    private TextView mTextView;

    private static int mDuration;
    private static boolean isOutDuration;

    private static final int ZERO_DURATION = 0;
    private static final int SHORT_DURATION = 2500;
    private static final int LONG_DURATION = 3000;

    private boolean isSetRadis;

    public SuperToast(@NonNull Context context) {
        mContext = context;
        initView();
        initData();
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mParentView = inflater.inflate(R.layout.supertoast, null, false);
        mCardView = mParentView.findViewById(R.id.toastCardView);
        mImageView = mParentView.findViewById(R.id.toastImageView);
        mTextView = mParentView.findViewById(R.id.toastTextView);
    }

    private void initData() {
        mCardView.setCardBackgroundColor(SuperToastUtils.NORMAL_COLOR);
        mTextView.setTextColor(SuperToastUtils.DEFAULT_TEXT_COLOR);

        mDuration = Toast.LENGTH_SHORT;
        isOutDuration = false;
        isSetRadis = false;

        mToast = new Toast(mContext);
        mToast.setView(mParentView);
    }

    @CheckResult
    public static SuperToast make(@NonNull Context context) {
        return new SuperToast(context);
    }

    @CheckResult
    public static SuperToast make(@NonNull Context context, @NonNull CharSequence text) {
        SuperToast superToast = make(context);
        superToast.setText(text);
        return superToast;
    }

    @CheckResult
    public static SuperToast make(@NonNull Context context, @NonNull CharSequence text, int duration) {
        SuperToast superToast = make(context);
        superToast.setText(text);
        superToast.setDuration(duration);
        return superToast;
    }

    @CheckResult
    public static SuperToast make(@NonNull Context context, @NonNull CharSequence text, @NonNull SuperToastType type) {
        SuperToast superToast = make(context);
        superToast.setText(text);
        superToast.setType(type);
        return superToast;
    }

    @CheckResult
    public static SuperToast make(@NonNull Context context, @NonNull CharSequence text, int duration, @NonNull SuperToastType type) {
        SuperToast superToast = make(context);
        superToast.setText(text);
        superToast.setDuration(duration);
        superToast.setType(type);
        return superToast;
    }

    @CheckResult
    public static SuperToast make(@NonNull Context context, @NonNull CharSequence text, @ColorInt int color, @DrawableRes int res) {
        SuperToast superToast = make(context);
        superToast.setText(text);
        superToast.setColor(color);
        superToast.setImage(res);
        return superToast;
    }

    @CheckResult
    public static SuperToast make(@NonNull Context context, @NonNull CharSequence text, int duration, @ColorInt int color, @DrawableRes int res) {
        SuperToast superToast = make(context);
        superToast.setText(text);
        superToast.setDuration(duration);
        superToast.setColor(color);
        superToast.setImage(res);
        return superToast;
    }

    public void setText(@NonNull CharSequence text) {
        mTextView.setText(text);
        if (!isSetRadis) {
            mCardView.post(new Runnable() {
                @Override
                public void run() {
                    int radis = mCardView.getHeight() / 2;
                    mCardView.setRadius(radis);
                }
            });
        }
    }

    public void setType(@NonNull SuperToastType type) {
        if (type == SuperToastType.NORMAL) {
            mImageView.setImageResource(R.drawable.ic_sentiment_neutral_black_24dp);
            mCardView.setCardBackgroundColor(SuperToastUtils.NORMAL_COLOR);
        } else if (type == SuperToastType.INFO) {
            mImageView.setImageResource(R.drawable.ic_info_outline_black_24dp);
            mCardView.setCardBackgroundColor(SuperToastUtils.INFO_COLOR);
        } else if (type == SuperToastType.SUCCESS) {
            mImageView.setImageResource(R.drawable.ic_check_black_24dp);
            mCardView.setCardBackgroundColor(SuperToastUtils.SUCCESS_COLOR);
        } else if (type == SuperToastType.WARNING) {
            mImageView.setImageResource(R.drawable.ic_error_outline_black_24dp);
            mCardView.setCardBackgroundColor(SuperToastUtils.WARNING_COLOR);
        } else if (type == SuperToastType.ERROR) {
            mImageView.setImageResource(R.drawable.ic_close_black_24dp);
            mCardView.setCardBackgroundColor(SuperToastUtils.ERROR_COLOR);
        }
    }

    public void setDuration(int duration) {
        mDuration = duration;
        if (duration >= ZERO_DURATION && duration <= LONG_DURATION) {
            mToast.setDuration(duration);
        } else {
            isOutDuration = true;
        }
    }

    public void setColor(@ColorInt int color) {
        mCardView.setCardBackgroundColor(color);
    }

    public void setImage(@DrawableRes int res) {
        if (res == -1) {
            mImageView.setVisibility(View.GONE);
        } else {
            mImageView.setImageResource(res);
        }
    }

    public void setImage(Drawable drawable) {
        mImageView.setImageDrawable(drawable);
    }

    public void setRadis(float radis) {
        mCardView.setRadius(radis);
    }

    public void setElevation(float elevation) {
        mCardView.setCardElevation(elevation);
    }

    public void setGravity(int gravity, int xOffset, int yOffset) {
        mToast.setGravity(gravity, xOffset, yOffset);
    }

    @CheckResult
    public int getDuration() {
        return mDuration;
    }

    @CheckResult
    public CardView getCardView() {
        return mCardView;
    }

    @CheckResult
    public TextView getTextView() {
        return mTextView;
    }

    @CheckResult
    public ImageView getImageView() {
        return mImageView;
    }

    public void show() {
        if (isOutDuration) {
            showLongToast(mToast, mDuration);
        } else {
            mToast.show();
        }
    }

    public void cancel() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    private void showLongToast(@NonNull final Toast toast, final int duration) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, ZERO_DURATION, 100);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, duration);
    }
}