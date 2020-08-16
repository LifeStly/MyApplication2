package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ReadUserFragment extends Fragment {
    private TextView TxtInfo;
    public  ReadUserFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_read_user,container,false);
        TxtInfo = view.findViewById(R.id.txt_display_info);

        List<User> users = MainActivity.myAppDatabase.myDao().getUser();
        String info = "";
        for(User usr : users){
            int id = usr.getId();
            String name = usr.getName();
            String phone = usr.getPhone();
            info = info+"\n\n"+"id :"+id+"\n Name :"+name+"\n"+"Phone :"+phone;
        }
        TxtInfo.setText(info);
        return view;
    }
}
