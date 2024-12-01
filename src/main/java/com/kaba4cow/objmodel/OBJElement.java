package com.kaba4cow.objmodel;

/**
 * Represents a generic element in an OBJ file. Each implementing class defines how to convert the element to its OBJ string
 * representation.
 */
public interface OBJElement {

	/**
	 * Converts this element to its OBJ string representation.
	 *
	 * @return the OBJ string representation of this element
	 */
	public String toOBJString();

}
