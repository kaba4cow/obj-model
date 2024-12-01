package com.kaba4cow.objmodel.elements;

import java.util.Objects;

import com.kaba4cow.objmodel.OBJElement;

/**
 * Represents a texture coordinate in an OBJ model. Texture coordinates are defined by two or three floating-point components
 * (u, v, w). The {@code w} component is optional.
 */
public class OBJTexture implements OBJElement {

	private float u;
	private float v;
	private Float w;

	/**
	 * Creates a new {@code OBJTexture} with {@code u} and {@code v} set to 0.0 and {@code w} unset (null).
	 */
	public OBJTexture() {
		this.u = 0.0f;
		this.v = 0.0f;
		this.w = null;
	}

	/**
	 * Retrieves the U component of the texture coordinate.
	 *
	 * @return the U component of the texture coordinate
	 */
	public float getU() {
		return u;
	}

	/**
	 * Sets the U component of the texture coordinate.
	 *
	 * @param u the new value for the U component
	 * 
	 * @return a reference to this texture coordinate
	 */
	public OBJTexture setU(float u) {
		this.u = u;
		return this;
	}

	/**
	 * Retrieves the V component of the texture coordinate.
	 *
	 * @return the V component of the texture coordinate
	 */
	public float getV() {
		return v;
	}

	/**
	 * Sets the V component of the texture coordinate.
	 *
	 * @param v the new value for the V component
	 * 
	 * @return a reference to this texture coordinate
	 */
	public OBJTexture setV(float v) {
		this.v = v;
		return this;
	}

	/**
	 * Retrieves the W component of the texture coordinate, or {@code null} if it is unset.
	 *
	 * @return the W component of the texture coordinate, or {@code null} if unset
	 */
	public Float getW() {
		return w;
	}

	/**
	 * Sets the W component of the texture coordinate.
	 *
	 * @param w the new value for the W component
	 * 
	 * @return a reference to this texture coordinate
	 */
	public OBJTexture setW(float w) {
		this.w = w;
		return this;
	}

	/**
	 * Checks if the W component of the texture coordinate is set.
	 *
	 * @return {@code true} if the W component is set, {@code false} otherwise
	 */
	public boolean hasW() {
		return Objects.nonNull(w);
	}

	/**
	 * Clears the W component of the texture coordinate, setting it to {@code null}.
	 *
	 * @return a reference to this texture coordinate
	 */
	public OBJTexture clearW() {
		this.w = null;
		return this;
	}

	/**
	 * Sets the U and V components of the texture coordinate.
	 *
	 * @param u the new value for the U component
	 * @param v the new value for the V component
	 * 
	 * @return a reference to this texture coordinate
	 */
	public OBJTexture set(float u, float v) {
		return setU(u).setV(v);
	}

	/**
	 * Sets the U, V, and W components of the texture coordinate.
	 *
	 * @param u the new value for the U component
	 * @param v the new value for the V component
	 * @param w the new value for the W component
	 * 
	 * @return a reference to this texture coordinate
	 */
	public OBJTexture set(float u, float v, float w) {
		return set(u, v).setW(w);
	}

	/**
	 * Converts this texture coordinate to its string representation in the OBJ format. The format is "vt u v" if {@code w} is
	 * unset, or "vt u v w" if {@code w} is set.
	 *
	 * @return the OBJ format string for this texture coordinate
	 */
	@Override
	public String toOBJString() {
		return hasW() //
				? String.format("vt %s %s %s", u, v, w) //
				: String.format("vt %s %s", u, v);
	}

	@Override
	public String toString() {
		return String.format("OBJTexture [u=%s, v=%s, w=%s]", u, v, w);
	}

}
