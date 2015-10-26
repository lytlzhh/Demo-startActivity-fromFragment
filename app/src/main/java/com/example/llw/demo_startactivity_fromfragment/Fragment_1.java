package com.example.llw.demo_startactivity_fromfragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_1 extends Fragment {
    private LinearLayout axiLinearlayout;
    private Button axiBack;
    private Button axiToActivity;
    private Fragment_1 fragment_1;
    private Fragment_2 fragment_2;

    public Fragment_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_fragment_1, null);
        axiBack = (Button) view.findViewById(R.id.axi_back);
        axiToActivity = (Button) view.findViewById(R.id.axi_to_activity);

        /* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^                          6…………… */
        axiBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = getActivity().getIntent();
                Intent intent = new Intent();
                intent.setClass(getActivity(), Main2Activity.class);
                String ss = "hello 你好吗？";
                intent.putExtra("H", ss);
                Toast.makeText(getActivity(), "hhhh", Toast.LENGTH_SHORT).show();
                getActivity().setResult(0x11, intent);
                Log.i("hh", "fdfhdkjfhfdkjfvkjfhdfihvdiufvfdvndkjvfdkjndffv");
                getActivity().finish();

        /* ssssssssssssssssssss                  sssssssssssssssssssssssssss                  ssssssssssssssssss    */
                //想实现返回到MainfestActivity界面，但是这里还没实现将其fragment隐藏起来??????????????????????????
             /*   FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if (fragment_1 != null) {
                    fragmentTransaction.hide(fragment_1);
                }
                if (fragment_2 != null) {
                    fragmentTransaction.hide(fragment_2);
                }

                fragmentTransaction.commit();*/

         /* ssssssssssssssssssss                  sssssssssssssssssssssssssss                  ssssssssssssssssss    */
            }
        });

          /*  ****************************************8              ****************************                *********** */
        axiToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), Main2Activity.class);
                Log.i("hd", "gggggggggggggggggggggggggg");
                startActivity(intent1);
            }
        });
        return view;//这里你要返回Fragment_1对象的xml对象否则无法显示界面   *********************************************
        //  return inflater.inflate(R.layout.fragment_fragment_1, container, false);
    }


}

