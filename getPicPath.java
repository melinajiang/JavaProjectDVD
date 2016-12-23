package dvdSockets;

import java.io.File;
import java.util.HashMap;

public class getPicPath {
static private HashMap< String, String> picPathMap;
//static private HashMap<String, String> hotPicPathMap;
//private File [] hotPics;

public getPicPath(HashMap< String, String> picPath) {
	// TODO Auto-generated constructor stub
	this.picPathMap = picPath;
	//hotPicPathMap = new HashMap<String, String>();
}
/*
public HashMap< String, String> getPicPath() {
	return picPath;
}
*/
public String getOnePicPath(String picName) {
	picName = picName+".PNG";
	if (picPathMap.containsKey(picName)) {
	String picPath = picPathMap.get(picName);
	return picPath;
	}
	else {
		return "wrong";
	}
}

}
