package Implements;

import java.util.List;

import Entity.Size;

public interface SizeImp {
	List<Size> lstSize();
	Size showSize(int idSize);
	String themSize(Size size);
	String updateSize(int idSize, String tenSize);
}
