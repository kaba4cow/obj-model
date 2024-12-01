package com.kaba4cow.objmodel.elements;

import com.kaba4cow.objmodel.OBJElement;

/**
 * Represents a vertex in an OBJ model. A vertex is defined by three floating-point components (x, y, z).
 */
public class OBJVertex implements OBJElement {

	private float x;
	private float y;
	private float z;

	/**
	 * Creates a new {@code OBJVertex} with all components initialized to 0.0.
	 */
	public OBJVertex() {
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
	}

	/**
	 * Retrieves the X component of the vertex.
	 *
	 * @return the X component of the vertex
	 */
	public float getX() {
		return x;
	}

	/**
	 * Sets the X component of the vertex.
	 *
	 * @param x the new value for the X component
	 * 
	 * @return a reference to this vertex
	 */
	public OBJVertex setX(float x) {
		this.x = x;
		return this;
	}

	/**
	 * Retrieves the Y component of the vertex.
	 *
	 * @return the Y component of the vertex
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the Y component of the vertex.
	 *
	 * @param y the new value for the Y component
	 * 
	 * @return a reference to this vertex
	 */
	public OBJVertex setY(float y) {
		this.y = y;
		return this;
	}

	/**
	 * Retrieves the Z component of the vertex.
	 *
	 * @return the Z component of the vertex
	 */
	public float getZ() {
		return z;
	}

	/**
	 * Sets the Z component of the vertex.
	 *
	 * @param z the new value for the Z component
	 * 
	 * @return a reference to this vertex
	 */
	public OBJVertex setZ(float z) {
		this.z = z;
		return this;
	}

	/**
	 * Sets the X, Y, and Z components of the vertex.
	 *
	 * @param x the new value for the X component
	 * @param y the new value for the Y component
	 * @param z the new value for the Z component
	 * 
	 * @return a reference to this vertex
	 */
	public OBJVertex set(float x, float y, float z) {
		return setX(x).setY(y).setZ(z);
	}

	/**
	 * Converts this vertex to its string representation in the OBJ format. The format is "v x y z".
	 *
	 * @return the OBJ format string for this vertex
	 */
	@Override
	public String toOBJString() {
		return String.format("v %s %s %s", x, y, z);
	}

	@Override
	public String toString() {
		return String.format("OBJVertex [x=%s, y=%s, z=%s]", x, y, z);
	}

}
