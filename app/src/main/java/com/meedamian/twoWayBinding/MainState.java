package com.meedamian.twoWayBinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainState extends BaseObservable {

    public final ObservableBoolean fieldsEnabled = new ObservableBoolean();

    // Basic EditText boilerplate
    private String basic;
    @Bindable
    public String getBasic() {
        return basic;
    }
    private void setBasicAtomic(String basic) {
        this.basic = basic;
    }
    public void setBasic(String basic) {
        setBasicAtomic(basic);
        notifyPropertyChanged(BR.basic);
    }
    public TextWatcher onBasicChanged = new SimpleTextWatcher() {
        @Override
        public void onTextChanged(String newBasic) {
            setBasicAtomic(newBasic);
        }
    };

    // Blurable EditText Boilerplate
    private String blurable;
    @Bindable
    public String getBlurable() {
        return blurable;
    }
    private void setBlurableAtomic(String blurable) {
        this.blurable = blurable;
    }
    public void setBlurable(String blurable) {
        setBlurableAtomic(blurable);
        notifyPropertyChanged(BR.blurable);
    }
    public TextWatcher onBlurableChanged = new SimpleTextWatcher() {
        @Override
        public void onTextChanged(String newBlurable) {
            setBlurableAtomic(newBlurable);
        }
    };
    public void onBlurableFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            Toast.makeText(v.getContext(), "Field blurred", Toast.LENGTH_SHORT).show();
    }

    // CheckBox change listener
    public void onCheckedChanged(View v) {
        fieldsEnabled.set(((CheckBox) v).isChecked());
    }
}
