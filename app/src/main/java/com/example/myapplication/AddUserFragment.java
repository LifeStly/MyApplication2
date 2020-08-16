package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserFragment extends Fragment {
    private EditText UserId,UserName,UserPhone;
    private Button BnSave;
    public AddUserFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_add_user,container,false);

        UserId = view.findViewById(R.id.txt_user_id);
        UserName = view.findViewById(R.id.txt_name);
        UserPhone = view.findViewById(R.id.txt_phone);
        BnSave = view.findViewById(R.id.bn_save_user);

        BnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userid = Integer.parseInt(UserId.getText().toString());
                String username = UserName.getText().toString();
                String userphone = UserPhone.getText().toString();

                User user = new User();
                user.setId(userid);
                user.setName(username);
                user.setPhone(userphone);

                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(),"User added successfully",Toast.LENGTH_LONG).show();
                UserId.setText("");
                UserName.setText("");
                UserPhone.setText("");
            }
        });

        return view;
    }
}
