package com.example.alex.facebooklayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.Button;

public class IconButton extends Button {

    public IconButton(final Context context) {
        super(context, null, R.attr.iconButton_style);
    }

    public IconButton(final Context context, final AttributeSet attrs) {
        super(context, attrs, R.attr.iconButton_style);
        init(attrs, R.attr.iconButton_style);
    }

    public IconButton(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, R.attr.iconButton_style);
        init(attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IconButton(final Context context, final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
        super(context, attrs, R.attr.iconButton_style, defStyleRes);
        init(attrs, defStyleAttr);
    }

    private void init(final AttributeSet attrs, final int defStyleAttr) {
        final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                R.styleable.IconButtonStyle, defStyleAttr, 0);
        try {
            final AppCompatDrawableManager drawableManager = AppCompatDrawableManager.get();

            Drawable topIcon = a.getDrawableIfKnown(R.styleable.IconButtonStyle_topIcon);
            Drawable bottomIcon = a.getDrawableIfKnown(R.styleable.IconButtonStyle_bottomIcon);
            Drawable leftIcon = a.getDrawableIfKnown(R.styleable.IconButtonStyle_leftIcon);
            Drawable rightIcon = a.getDrawableIfKnown(R.styleable.IconButtonStyle_rightIcon);

            int id = a.getResourceId(R.styleable.IconButtonStyle_topIcon, -1);
            if (id != -1) {
                topIcon = drawableManager.getDrawable(getContext(), id);
            }

            id = a.getResourceId(R.styleable.IconButtonStyle_bottomIcon, -1);
            if (id != -1) {
                bottomIcon = drawableManager.getDrawable(getContext(), id);
            }

            id = a.getResourceId(R.styleable.IconButtonStyle_rightIcon, -1);
            if (id != -1) {
                rightIcon = drawableManager.getDrawable(getContext(), id);
            }

            id = a.getResourceId(R.styleable.IconButtonStyle_leftIcon, -1);
            if (id != -1) {
                leftIcon = drawableManager.getDrawable(getContext(), id);
            }

            setCompoundDrawablesWithIntrinsicBounds(leftIcon, topIcon, rightIcon, bottomIcon);
        } finally {
            a.recycle();
        }
    }

}
