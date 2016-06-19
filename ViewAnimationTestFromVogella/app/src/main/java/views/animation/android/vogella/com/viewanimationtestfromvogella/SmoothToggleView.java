package views.animation.android.vogella.com.viewanimationtestfromvogella;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by raziq on 18/6/16.
 */
public class SmoothToggleView extends RelativeLayout {

    public static final long DURATION=300;

    View child1;
    View child2;
    boolean activated;
    AnimatorSet onAnimatorSet;
    ObjectAnimator onAnimator1;
    ObjectAnimator onAnimator2;
    ObjectAnimator onRotator1;
    ObjectAnimator onRotator2;

    AnimatorSet offAnimatorSet;
    ObjectAnimator offAnimator1;
    ObjectAnimator offAnimator2;
    ObjectAnimator offRotator1;
    ObjectAnimator offRotator2;


    public SmoothToggleView(Context context) {
        super(context);
    }

    public SmoothToggleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SmoothToggleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(){
        if (getChildCount() == 2) {
            activated=false;
            child1 = getChildAt(0);
            child2 = getChildAt(1);
            child2.setAlpha(0f);

            //While turning On
            onAnimatorSet = new AnimatorSet();
            onAnimator1 = ObjectAnimator.ofFloat(child1, "alpha", 1f, 0f);
            onAnimator1.setDuration(DURATION);
            onRotator1 = ObjectAnimator.ofFloat(child1, "rotation", 0, 90);
            onRotator1.setDuration(DURATION);
            onAnimator2 = ObjectAnimator.ofFloat(child2, "alpha", 0f, 1f);
            onAnimator2.setDuration(DURATION);
            onRotator2 = ObjectAnimator.ofFloat(child2, "rotation", 270, 360);
            onRotator2.setDuration(DURATION);
            onAnimatorSet.play(onAnimator1).with(onRotator1).with(onAnimator2).with(onRotator2);

            //While turning off
            offAnimatorSet = new AnimatorSet();
            offAnimator1 = ObjectAnimator.ofFloat(child2, "alpha", 1f, 0f);
            offAnimator1.setDuration(DURATION);
            offRotator1 = ObjectAnimator.ofFloat(child2, "rotation", 0, 90);
            offRotator1.setDuration(DURATION);
            offAnimator2 = ObjectAnimator.ofFloat(child1, "alpha", 0f, 1f);
            offAnimator2.setDuration(DURATION);
            offRotator2 = ObjectAnimator.ofFloat(child1, "rotation", 270, 360);
            offRotator2.setDuration(DURATION);
            offAnimatorSet.play(offAnimator1).with(offRotator1).with(offAnimator2).with(offRotator2);

        }


    }

    public void changeState(){

        if(activated){
            activated=false;
            turnOffState();
        }else{
            activated=true;
            turnOnState();
        }

    }

    private void turnOffState() {
        offAnimatorSet.start();
    }

    private void turnOnState() {
        onAnimatorSet.start();
    }
}
