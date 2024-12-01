package com.kaba4cow.objmodel.elements;

import com.kaba4cow.objmodel.OBJElement;

/**
 * Represents a normal vector in an OBJ model. Normals are defined by three floating-point coordinates (x, y, z).
 */
public class OBJNormal implements OBJElement {

	private float x;
	private float y;
	private float z;

	/**
	 * Creates a new {@code OBJNormal} with all components set to 0.0.
	 */
	public OBJNormal() {
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
	}

	/**
	 * Retrieves the X component of the normal.
	 *
	 * @return the X component of the normal
	 */
	public float getX() {
		return x;
	}

	/**
	 * Sets the X component of the normal.
	 *
	 * @param x the new value for the X component
	 * 
	 * @return a reference to this normal
	 */
	public OBJNormal setX(float x) {
		this.x = x;
		return this;
	}

	/**
	 * Retrieves the Y component of the normal.
	 *
	 * @return the Y component of the normal
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the Y component of the normal.
	 *
	 * @param y the new value for the Y component
	 * 
	 * @return a reference to this normal
	 */
	public OBJNormal setY(float y) {
		this.y = y;
		return this;
	}

	/**
	 * Retrieves the Z component of the normal.
	 *
	 * @return the Z component of the normal
	 */
	public float getZ() {
		return z;
	}

	/**
	 * Sets the Z component of the normal.
	 *
	 * @param z the new value for the Z component
	 * 
	 * @return a reference to this normal
	 */
	public OBJNormal setZ(float z) {
		this.z = z;
		return this;
	}

	/**
	 * Sets all three components of the normal at once.
	 *
	 * @param x the new value for the X component
	 * @param y the new value for the Y component
	 * @param z the new value for the Z component
	 * 
	 * @return a reference to this normal
	 */
	public OBJNormal set(float x, float y, float z) {
		return setX(x).setY(y).setZ(z);
	}

	/**
	 * Converts this normal to its string representation in the OBJ format. The format is "vn x y z", where x, y, and z are the
	 * components of the normal.
	 *
	 * @return the OBJ format string for this normal
	 */
	@Override
	public String toOBJString() {
		return String.format("vn %s %s %s", x, y, z);
	}

	@Override
	public String toString() {
		return String.format("OBJNormal [x=%s, y=%s, z=%s]", x, y, z);
	}

}
