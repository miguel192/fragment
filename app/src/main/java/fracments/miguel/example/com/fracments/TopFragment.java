package fracments.miguel.example.com.fracments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by migue_000 on 8/31/2017.
 */

public class TopFragment extends Fragment {

    private EditText editText;
    ToolbarListener activityCallback;

    public interface ToolbarListener {
        public void onButtonClick(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityCallback = (ToolbarListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement ToolbarListener");
        }
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.topfragment, container, false);

        editText = view.findViewById(R.id.edit_text);

        Button button = view.findViewById(R.id.action_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked(view);
            }

        });

        return view;
    }

    public void buttonClicked(View view) {
        activityCallback.onButtonClick(editText.getText().toString());
    }



}
