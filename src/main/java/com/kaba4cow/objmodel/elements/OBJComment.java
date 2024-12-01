package com.kaba4cow.objmodel.elements;

import java.util.Objects;

import com.kaba4cow.objmodel.OBJElement;

/**
 * Represents a comment in an OBJ file. Comments are prefixed with {@code #} in the OBJ format.
 */
public class OBJComment implements OBJElement {

	private String text;

	/**
	 * Creates an empty comment.
	 */
	public OBJComment() {
		this.text = null;
	}

	/**
	 * Returns the comment text.
	 *
	 * @return the comment text or {@code null} if not set
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the comment text.
	 *
	 * @param text the text of the comment
	 * 
	 * @return a reference to this object
	 */
	public OBJComment setText(String text) {
		this.text = text;
		return this;
	}

	/**
	 * Checks if the comment has text.
	 *
	 * @return {@code true} if the comment has text, {@code false} otherwise
	 */
	public boolean hasText() {
		return Objects.nonNull(text);
	}

	/**
	 * Clears the comment text.
	 *
	 * @return a reference to this object
	 */
	public OBJComment clearText() {
		this.text = null;
		return this;
	}

	/**
	 * Converts the comment to its OBJ string representation.
	 *
	 * @return the OBJ string representation of this comment
	 */
	@Override
	public String toOBJString() {
		return String.format("# %s", text);
	}

	@Override
	public String toString() {
		return String.format("OBJComment [text=%s]", text);
	}

}
