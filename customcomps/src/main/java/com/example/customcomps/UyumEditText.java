package com.example.customcomps;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.customcomps.helpers.TextValidation;
import com.example.customcomps.helpers.UyumConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class UyumEditText extends LinearLayout  {

    public ImageView img;
    public EditText editText;

    public int type=3;


    public final Vector<Character> maskChars=new Vector<>(Arrays.asList('#','L'));

    public UyumEditText(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.edittext_layout,this,true);
        img=findViewById(R.id.imageView);
        editText=findViewById(R.id.editText);

        final TypedArray typedArray=context.obtainStyledAttributes(attributeSet,R.styleable.UyumEditText);
        try{

            boolean drawableGiven=false;
            String placeholder=null;
            for(int i=0;i<typedArray.getIndexCount();i++){

                int attr=typedArray.getIndex(i);

                if(attr==R.styleable.UyumEditText_TextType){
                    type=typedArray.getInt(attr,3);
                }else if(attr==R.styleable.UyumEditText_Placeholder){
                    placeholder=typedArray.getString(attr);
                }

            }

            setType(type);
            setPlaceholder(placeholder);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            typedArray.recycle();
        }

        setMask("0(###) ### ## ##");

        /*
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                boolean valid=true;
                if(type==UyumConstants.EditTextTypes.EMail){
                    valid= TextValidation.isValidEmail(charSequence);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

         */
    }

    public void setType(int type){
        this.type=type;
        editText.setRawInputType(Configuration.KEYBOARD_QWERTY);
        if(type== UyumConstants.EditTextTypes.Password){
            img.setVisibility(VISIBLE);
            editText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }else{
            img.setVisibility(GONE);
            if(type==UyumConstants.EditTextTypes.Name){
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
            }else if(type==UyumConstants.EditTextTypes.Phone){
                editText.setInputType(InputType.TYPE_CLASS_PHONE);
            }else if(type==UyumConstants.EditTextTypes.EMail){
                editText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
            }else if(type==UyumConstants.EditTextTypes.Date){
                editText.setInputType(InputType.TYPE_CLASS_DATETIME);
            }else if(type==UyumConstants.EditTextTypes.TCKN){
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            }

        }

    }
    public void setPlaceholder(String s){
        if(s!=null)
            editText.setHint(s);
        else{
            if(type==UyumConstants.EditTextTypes.Name){
                editText.setHint("İsim");
            }else if(type==UyumConstants.EditTextTypes.Phone){
                editText.setHint("Telefon No");
            }else if(type==UyumConstants.EditTextTypes.EMail){
                editText.setHint("E-Mail");
            }else if(type==UyumConstants.EditTextTypes.Password){
                editText.setHint("Şifre");
            }else if(type==UyumConstants.EditTextTypes.Date){
                editText.setHint("Tarih");
            }else if(type==UyumConstants.EditTextTypes.TCKN){
                editText.setHint("TC Kimlik No");
            }
        }
    }

    public void setMask(final String mask){
        editText.setText("");
        final Vector<Integer> vec=new Vector<>();
        int firstInputIndex=-1;

        for(int i=0;i<mask.length();i++){
            char c=mask.charAt(i);
            if(maskChars.contains(c)){
                if(firstInputIndex==-1){
                    firstInputIndex=i;
                }
                vec.add(i);
                editText.setText(editText.getText()+"-");
            }else{
                editText.setText(editText.getText()+String.valueOf(c));
            }
        }
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    editText.post(new Runnable() {
                        @Override
                        public void run() {
                            editText.setSelection(Collections.min(vec));
                        }
                    });

                }
            }
        });

        final Vector<Character> chars=new Vector<>();
        final Vector<Character> writtenChars=new Vector<>();
        final Vector<Integer> deletedIndices=new Vector<>();

        final int finalFirstInputIndex = firstInputIndex;
        editText.addTextChangedListener(new TextWatcher() {

            String textbefore="";
            String textafter="";
            int index=0;
            int dontcareindex=-1;
            String beforechange="";
            int selectlocation=0;

            int changedIndex=-1;
            boolean skip=false;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textbefore=charSequence.toString();
                index=i;
                beforechange=charSequence.toString();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textafter=charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

                /*
                    if (editable.length() > index + 1) {
                        if (index<mask.length()&&mask.charAt(index) == '#') {
                            if (index != dontcareindex) {
                                dontcareindex = 0;
                                CharSequence s1 = editable.subSequence(0, index + 1);
                                CharSequence s = editable.subSequence(index + 2, editable.length());
                                String str = s1.toString() + s.toString();
                                vec.remove((Integer)index);
                                editable.replace(0, editable.length(), s1.toString() + s.toString());
                                if(vec.size()>0)
                                    editText.setSelection(Collections.min(vec));
                                else
                                    editText.setSelection(mask.length());
                                int b=4;
                            } else {
                                dontcareindex = -1;
                            }
                        }
                    }
                    if(editable.length()>mask.length()){
                        dontcareindex=0;
                        editable.replace(0,editable.length(),beforechange);
                    }

                 */


                if(!skip) {
                    if(chars.size()>0) {
                        if(writtenChars.size()!=vec.size())
                            writtenChars.addAll(chars);
                        int z = 0;
                        StringBuilder replacement = new StringBuilder();
                        int selectlocation = 0;
                        boolean sel=true;
                        for (int i = 0; i < mask.length(); i++) {

                            if (z < writtenChars.size() && maskChars.contains(mask.charAt(i))) {

                                replacement.append(writtenChars.get(z).toString());
                                z++;


                            } else {
                                if (maskChars.contains(mask.charAt(i))) {
                                    replacement.append("-");
                                    if(sel&&writtenChars.size()!=0){
                                        selectlocation=i;
                                        sel=false;
                                    }
                                } else {
                                    replacement.append(mask.charAt(i));
                                }

                            }
                        }
                        skip = true;
                        editable.delete(0, editable.length());
                        editable.append(replacement.toString());
                        if(writtenChars.size()==vec.size())
                            editText.setSelection(editable.length());
                        else
                            editText.setSelection(selectlocation);
                        skip = false;
                        chars.clear();
                    }
                    if(deletedIndices.size()>0){
                        /*
                        int ind=-1;
                        for(int i=0;i<=deletedIndices.get(0);i++){
                            if(maskChars.contains(mask.charAt(i))){
                                ind++;
                            }

                        }

                         */
                            //writtenChars.insertElementAt('-',ind);
                            if(writtenChars.size()>0)
                                writtenChars.remove(writtenChars.size()-1);
                            //chars.clear();
                            //chars.addAll(writtenChars);
                           // writtenChars.clear();
                            StringBuilder replacement = new StringBuilder();
                            int selectlocation = 0;
                            int z=0;
                            boolean sel=true;
                            for (int i = 0; i < mask.length(); i++) {

                                if (z < writtenChars.size() && maskChars.contains(mask.charAt(i))) {

                                    replacement.append(writtenChars.get(z).toString());
                                    //editable.replace(i,1,a);
                                    z++;
                                    /*
                                    if (z == writtenChars.size()) {
                                        //selectlocation = i + 1;
                                        sel=true;
                                    }

                                     */

                                } else {
                                    if (maskChars.contains(mask.charAt(i))) {
                                        replacement.append("-");
                                        if(sel&&writtenChars.size()!=0){
                                            selectlocation=i;
                                            sel=false;
                                        }
                                    } else {

                                        replacement.append(mask.charAt(i));
                                    }
                                    //editable.replace(i,1,mask.charAt(i)+"");
                                    //editable.delete(0,editable.length()-1);
                                    //Editable d=editable;
                                }
                            }
                            skip = true;
                            editable.delete(0, editable.length());
                            editable.append(replacement.toString());
                            if(writtenChars.size()==0)
                                editText.setSelection(finalFirstInputIndex);
                            else
                                editText.setSelection(selectlocation);
                            skip = false;

                        deletedIndices.clear();
                        chars.clear();
                    }
                }



            }
        });

        InputFilter filter = new InputFilter() {
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {

                boolean valid=true;

                if(valid) {
                    if (chars.size() == 0) {
                        for (int i = 0; i < source.length(); i++) {
                            chars.add(source.charAt(i));
                        }
                        if (source == "" && deletedIndices.size() == 0) {
                            deletedIndices.add(dstart);
                        }
                    }
                }else{
                    return "";
                }


               // if(source.toString().length()==1){
                    /*
                    StringBuffer stringBuffer=new StringBuffer(dest);
                    String s="";
                    if(dstart<mask.toString().length()){
                        stringBuffer.insert(dstart,source);
                        s=stringBuffer.deleteCharAt(dstart+1).toString();

                    }else{
                        return "";
                        // s=stringBuffer.insert(dstart,source).toString();
                    }
                    //String s=stringBuffer.insert(dstart,source).toString();
                    if(fitsMask(s,mask)){
                       return null;
                    }


                    return null;*/
               // }
                /*
                if(dstart>=mask.toString().length()){
                    return "";
                    // s=stringBuffer.insert(dstart,source).toString();
                }

                 */
                return null;

            }
        };

        editText.setFilters(new InputFilter[] { filter });
    }
    /*
    private String getReplacement(String mask,Vector<Character> writtenChars,){
        String replacement="";
        for (int i = 0; i < mask.length(); i++) {

            if (z < writtenChars.size() && maskChars.contains(mask.charAt(i))) {

                replacement += writtenChars.get(z).toString();
                //editable.replace(i,1,a);
                z++;
                if (z == writtenChars.size()) {
                    selectlocation = i + 1;
                }

            } else {
                if (maskChars.contains(mask.charAt(i))) {
                    replacement += "_";
                } else {
                    replacement += mask.charAt(i);
                }
                //editable.replace(i,1,mask.charAt(i)+"");
                //editable.delete(0,editable.length()-1);
                //Editable d=editable;
            }
        }
    }

     */

    private void calculateSelectionIndex(){

    }
    public boolean validateInput(String s){

        if(type==UyumConstants.EditTextTypes.EMail){

        }else if(type==UyumConstants.EditTextTypes.Phone){
            return s.matches("\\d+");

        }
        return true;
    }

    public boolean validate(String s){
        boolean valid=true;
        if(type==UyumConstants.EditTextTypes.EMail){
            valid= TextValidation.isValidEmail(s);
        }else if(type==UyumConstants.EditTextTypes.Phone){
            valid=TextValidation.isValidPhoneNumber(s);
        }
        return valid;
    }

    public InputFilter maskFilter(final String mask){
        final InputFilter filter = new InputFilter() {
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {

                if(source.toString().length()==1){
                    StringBuffer stringBuffer=new StringBuffer(dest);
                    String s="";
                    if(dstart<mask.toString().length()){
                        stringBuffer.insert(dstart,source);
                        s=stringBuffer.deleteCharAt(dstart+1).toString();

                    }else{
                        return "";
                       // s=stringBuffer.insert(dstart,source).toString();
                    }
                    //String s=stringBuffer.insert(dstart,source).toString();
                    if(fitsMask(s,mask)){
                        return s;
                    }


                }




                return "";
                /*
                for (int i = start; i < end; i++) {
                    if (!Character.isLetterOrDigit(source.charAt(i))) {
                        return "";
                    }
                }

                 */
               // return "";
            }
        };
        return filter;
    }

    private boolean fitsMask(String input,String mask){
        if(input.length()>mask.length())
            return false;

        for(int i=0;i<input.length();i++){
            if(mask.charAt(i)=='#'){
                if(!Character.isDigit(input.charAt(i))&&input.charAt(i)!='_'){
                    return false;
                }
            }else if(mask.charAt(i)=='L'){
                if(!Character.isLetter(input.charAt(i))&&input.charAt(i)!='_'){
                    return false;
                }
            }else{
                if(input.charAt(i)!='_'&&input.charAt(i)!=mask.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

}
