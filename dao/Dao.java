package dao;



import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dao<T> {
	String clazzname;
	Class clazz;
	String jsonfile;
	public Dao(T entity) {
		clazz=entity.getClass();
		clazzname=clazz.getSimpleName().toLowerCase();
		jsonfile=clazzname+".txt";
		File file=new File(jsonfile);
		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	//check the file and get the list of users by key
	public List<T> queryByKey(String name,String keyvalue){
		List<String> slist=FileUtil.readFileByLines(jsonfile);
		
		List<T> tlist=new ArrayList<>();
		for (int i = 0; i < slist.size(); i++) {
			T t=txtToEntity(slist.get(i));
			Object tvalue= getValue(t, name, clazz);
			if(tvalue.equals(keyvalue)){
				tlist.add(t);
			}
			
		}
		return tlist;
	}
	public List<T> query(T entity){
		List<T> list=getAll();
		List<String> prolist=new ArrayList<>();
		for (Field field : clazz.getDeclaredFields()) {
			if(!field.getName().equals("id")){
				Object obj=getValue(entity, field.getName(), clazz);
				if(obj!=null&&!obj.toString().equals("")){
					prolist.add(field.getName());
				}
			}
		}
		List<T> resList = new ArrayList<>();
		for (T e : list) {
			boolean flag = true;
			if(flag){
				for(int i = 0; i < prolist.size(); i++){
					String filterProp = prolist.get(i);
					String keyword = getValue(entity, filterProp, clazz).toString();
					Object value = getValue(e, filterProp, clazz);
					if(value == null || !value.toString().toLowerCase().contains(keyword.toLowerCase())){
						flag = false;
						break;
					}
				}
			}
			if(flag){
				resList.add(e);
			}
		}
		list.clear();
		list.addAll(resList);
		return list;
	}
	public T txtToEntity(String txt){
		T t = null;
		try {
			t = (T) clazz.newInstance();
			String pros[]=txt.split(",");
			for (int i = 0; i < pros.length; i++) {
				String pro[]=pros[i].split(":");
				if(pro[0].equals("id")){
					setValue(pro[0], clazz, t, Integer.valueOf(pro[1]));
				}else{
					setValue(pro[0], clazz, t, pro[1]);
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return t;
	}
	public String entityToTxt(T t){
		StringBuffer sbf = new StringBuffer();
		for (Field field : clazz.getDeclaredFields()) {
				Object obj=getValue(t, field.getName(), clazz);
				if(obj!=null&&!obj.toString().equals("")){
					sbf.append(field.getName()+":"+obj).append(",");
				}
		}
		
		return sbf.toString();
	}
	//get all the datas
	public List<T> getAll(){
		List<String> slist=FileUtil.readFileByLines(jsonfile);
		List<T> tlist=new ArrayList<>();
		for (int i = 0; i < slist.size(); i++) {
			tlist.add(txtToEntity(slist.get(i)));
		}
		return tlist;
	}
	//delete the data by key
	public void delBykey(String name,String key) {
		List<T> tlist=getAll();
		for (int i = 0; i < tlist.size(); i++) {
			Object value= getValue(tlist.get(i), name, clazz);
			if(value.toString().equals(key)){
				tlist.remove(i);break;
			}
		}
		try {
			FileUtil.writeTxtFile(listToStr(tlist), new File(jsonfile));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String listToStr(List<T> tlist){
		StringBuffer sbf=new StringBuffer();
		for (int i = 0; i < tlist.size(); i++) {
			sbf.append(entityToTxt(tlist.get(i))).append("\r\n");
		}
		return sbf.toString();
	}
	//update the user data
	public void update(T entity) {
		Integer value1=(Integer) getValue(entity, getKey(), clazz);
		List<T> tlist=getAll();
		for (int i = 0; i < tlist.size(); i++) {
			Integer value=(Integer) getValue(tlist.get(i), getKey(), clazz);
			
			if(value.toString().equals(value1.toString())){
				try {
					for (Field field : clazz.getDeclaredFields()) {
						Object o=getValue(entity, field.getName(), clazz);
						setValue(field.getName(), clazz, tlist.get(i), o);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}
		try {
			FileUtil.writeTxtFile(listToStr(tlist), new File(jsonfile));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//add new user
	public void add(T t) {
		setValue("id", clazz, t, new Random().nextInt(100000));
		List<T> tlist=getAll();
		tlist.add(t);
		try {
			FileUtil.writeTxtFile(listToStr(tlist), new File(jsonfile));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Object getValue(Object entity, String fieldName, Class clazz) {
		PropertyDescriptor pd;
		try {
			pd = new PropertyDescriptor(fieldName, clazz);
			Method wM = pd.getReadMethod();
			return wM.invoke(entity)==null?"":wM.invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	public void setValue(String fieldName,Class clazz,Object o,Object fieldValue){
		try {
			PropertyDescriptor pd = new PropertyDescriptor(fieldName, clazz);
			Method wM = pd.getWriteMethod();
			wM.invoke(o, fieldValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getKey() {
		try {
			for (Field field : clazz.getDeclaredFields()) {
					return field.getName();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
