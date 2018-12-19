package captain.wonjong.testproj.util;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.view.View;

public class MyBindingAdapter {
    @BindingConversion
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }
}
