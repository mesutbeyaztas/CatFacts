package com.mesut.beyaztas.cat.facts.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Mesut on 04/11/2017.
 */

public class KeyboardUtils {

    public static void hideKeyboard(Context context, EditText field) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(field.getWindowToken(), 0);
    }

}
