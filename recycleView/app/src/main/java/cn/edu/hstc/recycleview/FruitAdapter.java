package cn.edu.hstc.recycleview;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;
    PopupMenu popup=null;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);

            fruitName = (TextView) view.findViewById(R.id.fruit_name);

        }
    }

    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });


        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final int position = holder.getAdapterPosition();
                final Fruit fruit = mFruitList.get(position);
                //创建PopupMenu对象
                popup=new PopupMenu(v.getContext(),v);
                //将R.menu.popup_menu菜单资源加载到popup菜单中
                popup.getMenuInflater().inflate(R.menu.main,popup.getMenu());
                //为popup菜单的菜单项单击事件绑定事件监听器
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId())
                        {
                            case R.id.add:
                                Fruit pear = new Fruit("pear", R.drawable.pear_pic);
                                mFruitList.add(position , pear);
                                notifyItemInserted(position);
                                if(position!=getItemCount()){
                                    notifyItemRangeChanged(position,getItemCount());
                                    Toast.makeText(v.getContext(), "add successfully " , Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case R.id.delete:
                                mFruitList.remove(position);
                                notifyItemRemoved(position);
                                if(position!=getItemCount()){
                                    notifyItemRangeChanged(position,getItemCount());
                                    Toast.makeText(v.getContext(), "delete"+fruit.getName()+" successfully " , Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case R.id.look:
                                Toast.makeText(v.getContext(), "you clicked image : " +position , Toast.LENGTH_SHORT).show();
                                if(position!=getItemCount()){
                                    notifyItemRangeChanged(position,getItemCount());
                                }
                                break;
                            case R.id.update:
                                Fruit banana = new Fruit("banana", R.drawable.banana_pic);
                                mFruitList.set(position , banana);
                                notifyItemChanged(position);
                                if(position!=getItemCount()){
                                    notifyItemRangeChanged(position,getItemCount());
                                    Toast.makeText(v.getContext(), "update successfully " , Toast.LENGTH_SHORT).show();
                                }
                                break;

                        }
                        // TODO Auto-generated method stub
                        return false;
                    }

                });
                popup.show();

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());

    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }


}
