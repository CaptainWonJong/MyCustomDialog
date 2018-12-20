package captain.wonjong.testproj.util;

import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Utils {
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    public static void loadImage(ImageView imageView, @DrawableRes int url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
