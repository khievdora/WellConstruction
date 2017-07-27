/*
 * Copyright (C) 2017. All rights reserved.
 * @author Dora Khiev
 */

package qv21.com.wellconstruction.view;

/**
 * Created by Dora on 7/27/2017.
 */

/**
 * Interface represent BaseView for all screen.
 */
public interface BaseView {

    /**
     * Display Toast as a message to user.
     * @param message : Content message to be displayed
     * @param duration : Duration like Toast.LONG or Toast.SHORT
     */
    public void showToast(String message, int duration);

    /**
     * Display dialog messsage to user
     * @param message : content message
     * @param dialogType : DialogType, it could be warning, info, error, etc.
     */
    public void showDialogMessage(String message, int dialogType);

}
