package alisha.digipodium.menus_01;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FirstFragment extends Fragment {

    private TextView textNote,textNote1;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textNote = view.findViewById(R.id.textNote);
        textNote1 = view.findViewById(R.id.textNote1);
        ImageView imgMenu = view.findViewById(R.id.imgMenu);
        ImageView imgMenu1 = view.findViewById(R.id.imgMenu1);

        /*TextView textView=view.findViewById(R.id.textView);
        registerForContextMenu(textView);*/
        /*FloatingActionButton fab=view.findViewById(R.id.fab);
        registerForContextMenu(fab);*/

        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pop = new PopupMenu(getActivity(), v);
                pop.getMenuInflater().inflate(R.menu.menu_notes_popup, pop.getMenu());
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.note_pop_copy:
                                String data = textNote.getText().toString();
                                ClipboardManager manager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                                ClipData clipData = ClipData.newPlainText("note", data);
                                manager.setPrimaryClip(clipData);
                                Toast.makeText(getActivity(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.note_pop_edit:
                                break;
                            case R.id.note_pop_share:
                                String notes = textNote.getText().toString();
                                Intent intent = ShareCompat.IntentBuilder.from(getActivity()).setSubject("note").setText(notes).createChooserIntent();
                                startActivity(intent);
                                break;
                        }
                        return true;
                    }
                });
                pop.show();
            }
        });
        imgMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pop = new PopupMenu(getActivity(), v);
                pop.getMenuInflater().inflate(R.menu.menu_notes_popup, pop.getMenu());
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.note_pop_copy:
                                String data = textNote1.getText().toString();
                                ClipboardManager manager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                                ClipData clipData = ClipData.newPlainText("note", data);
                                manager.setPrimaryClip(clipData);
                                Toast.makeText(getActivity(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.note_pop_edit:
                                break;
                            case R.id.note_pop_share:
                                String notes = textNote1.getText().toString();
                                Intent intent = ShareCompat.IntentBuilder.from(getActivity()).setSubject("note 1").setText(notes).createChooserIntent();
                                startActivity(intent);
                                break;
                        }
                        return true;
                    }
                });pop.show();
            }
        });
    }
    /*@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextual_menu,menu);
        menu.setHeaderTitle("choose your option");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.attach_pdf:
                Toast.makeText(this,"select pdf from your device",Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.attach_docx:
                Toast.makeText(this,"Select Docx form your device",Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.attach_image:
                Toast.makeText(this,"Select image from your device",Toast.LENGTH_SHORT).show();
                return  true;
        }
        return super.onContextItemSelected(item);
    }*/
}
         /*  @Override
           public void onClick(View v) {
               PopupMenu pop = new PopupMenu(getActivity(), v);
               pop.getMenuInflater().inflate(R.menu.menu_notes_popup, pop.getMenu());
               switch (v.getId()){
                   case R.id.imgMenu:
                       pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                           @Override
                           public boolean onMenuItemClick(MenuItem item) {
                               switch (item.getItemId()) {
                                   case R.id.note_pop_copy:
                                       String data = textNote.getText().toString();
                                       ClipboardManager manager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                                       ClipData clipData = ClipData.newPlainText("note", data);
                                       manager.setPrimaryClip(clipData);
                                       Toast.makeText(getActivity(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
                                       break;
                                   case R.id.note_pop_edit:
                                       break;
                                   case R.id.note_pop_share:
                                       String notes = textNote.getText().toString();
                                       Intent intent = ShareCompat.IntentBuilder.from(getActivity()).setSubject("note").setText(notes).createChooserIntent();
                                       startActivity(intent);
                                       break;
                               }
                               return true;
                           }
                       });
                       break;
                       case R.id.imgMenu1:
                           pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                               @Override
                               public boolean onMenuItemClick(MenuItem item) {
                                   switch (item.getItemId()) {
                                       case R.id.note_pop_copy:
                                           String data = textNote1.getText().toString();
                                           ClipboardManager manager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                                           ClipData clipData = ClipData.newPlainText("note", data);
                                           manager.setPrimaryClip(clipData);
                                           Toast.makeText(getActivity(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
                                           break;
                                       case R.id.note_pop_edit:
                                           break;
                                       case R.id.note_pop_share:
                                           String notes = textNote1.getText().toString();
                                           Intent intent = ShareCompat.IntentBuilder.from(getActivity()).setSubject("note 1").setText(notes).createChooserIntent();
                                           startActivity(intent);
                                           break;
                                   }
                                   return true;
                               }
                           });
               }
               pop.show();
           }}*/