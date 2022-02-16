package com.example.bestlist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class DayAdapter extends ArrayAdapter<Day>{
    private Context context;
    private Day [] days;

    public DayAdapter(@NonNull Context context, @NonNull Day[]objects) {
        super(context, R.layout.mylist,R.id.title,objects);
        this.context = context;
        days=objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        ViewHolder viewHolder;
        if(view == null){
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.mylist,parent,false);
             viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder)view.getTag();
        }

        TextView textViewTitle=view.findViewById(R.id.title);
        TextView textViewDescription =view.findViewById(R.id.subtitle);
        ImageView imageView=view.findViewById(R.id.imageView);
        textViewTitle.setText(days[position].getDayTitle());
        textViewDescription.setText(days[position].getDayDescription());
        imageView.setImageBitmap(decodeSampledBitmapFromResources(getContext().getResources()
                ,days[position].getImageResourceId(),
                80,80));
        return  view;
    }
    class ViewHolder{
        private TextView textViewTitle;
        private TextView textViewDescription;
        private ImageView imageView;
        private View view;
        ViewHolder(View v){
            view=v;
        }
        public TextView getTextViewTitle(){
            if(textViewTitle==null){
                textViewTitle=view.findViewById(R.id.title);
            }
            return  textViewTitle;
        }
        public  TextView getTextViewDescription(){
            if(textViewDescription==null){
                textViewDescription=view.findViewById(R.id.subtitle);
            }
            return textViewDescription;
        }
        public ImageView getImageView(){
            if(imageView==null){
                imageView=view.findViewById(R.id.imageView);
                
            }
            return imageView;
        }
    }
    public static Bitmap decodeSampledBitmapFromResources (Resources res,int resId,int reqWidth,int reqHeight){
        final BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeResource(res,resId,options);
        options.inSampleSize=calculateInSampleSize(options,reqWidth,reqHeight);
        options.inJustDecodeBounds=false;
        return BitmapFactory.decodeResource(res,resId,options);
    }
    public static int calculateInSampleSize( BitmapFactory.Options options,int reqWidth,int reqHeight){
        final int height=options.outHeight;
        final int width=options.outWidth;
        int inSampleSize=1;
        if(height>reqHeight || width>reqWidth){
            final  int halfHeight=height/2;
            final int halfWidth=width/2;
            while ((halfWidth/inSampleSize)>reqHeight&&(halfHeight/inSampleSize)>reqWidth){
                inSampleSize *=2;
            }
        }
        return inSampleSize;
    }
}