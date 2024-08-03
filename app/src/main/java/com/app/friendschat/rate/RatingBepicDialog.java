package com.app.friendschat.rate;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.app.friendschat.R;
import com.app.friendschat.utils.EventTracking;

public class RatingBepicDialog extends Dialog {

    private Context contextBepic;
    private RelativeLayout rlSendBepic, rlCancelBepic;
    private OnPress onPressBepic;
    private RatingBar rtbBepic;
    private RelativeLayout rlOkay;



    public RatingBepicDialog(Context context2) {
        super(context2, R.style.CustomAlertDialog);
        this.contextBepic = context2;
        setContentView(R.layout.dialog_rating_app_bepic);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(attributes);
        getWindow().setSoftInputMode(16);
        rtbBepic = (RatingBar) findViewById(R.id.rtb);
        rlSendBepic = (RelativeLayout) findViewById(R.id.rlSend);
        rlCancelBepic = (RelativeLayout) findViewById(R.id.rlCancel);
        rtbBepic.setRating(5.0f);

        onclick();
    }

    public interface OnPress {
        void send(float rate);

        void rating();

        void cancel();

        void later();
    }

    public void init(Context context, OnPress onPress) {
        this.onPressBepic = onPress;
    }

    public void setOnPressBepic(OnPress onPressBepic) {
        this.onPressBepic = onPressBepic;
    }

    public void onclick() {
        rlSendBepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int starNumber = (int) rtbBepic.getRating();

                if (starNumber == 0) {
                    Toast.makeText(contextBepic, contextBepic.getResources().getString(R.string.Please_feedback), Toast.LENGTH_SHORT).show();
                    return;
                }
                if (starNumber <= 3.0) {
                    onPressBepic.send(rtbBepic.getRating());
                } else {
                    //Edit
                    onPressBepic.rating();
                }

                Bundle bundle = new Bundle();
                bundle.putString("rate_star", String.valueOf(starNumber));
                EventTracking.INSTANCE.logEvent(contextBepic, EventTracking.EVENT_NAME_RATE_SUBMIT);
            }
        });

        rlCancelBepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPressBepic.later();
                EventTracking.INSTANCE.logEvent(contextBepic, EventTracking.EVENT_NAME_RATE_NOT_NOW);
            }
        });
    }
}
