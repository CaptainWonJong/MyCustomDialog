package captain.wonjong.testproj.util;

import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.ImageView;

public class BindingUtils {

    @BindingConversion
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        Utils.loadImage(imageView, url);
    }

    @BindingAdapter({"bind:imageUrlDrawable"})
    public static void loadImage(ImageView imageView, @DrawableRes Integer url) {
        Utils.loadImage(imageView, url);
    }
}
