package com.kaba4cow.objmodel.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.kaba4cow.objmodel.OBJElement;

/**
 * Represents a face in an OBJ file. A face consists of a set of indices that refer to vertices, textures, and normals. Faces
 * are prefixed with {@code f} in the OBJ format.
 */
public class OBJFace implements OBJElement {

	private final List<OBJIndex> indices;

	/**
	 * Creates an empty face.
	 */
	public OBJFace() {
		this.indices = new ArrayList<>();
	}

	/**
	 * Returns the indices of this face.
	 *
	 * @return an unmodifiable list of indices
	 */
	public List<OBJIndex> getIndices() {
		return Collections.unmodifiableList(indices);
	}

	/**
	 * Returns the index at the specified position.
	 *
	 * @param index the position of the index to retrieve
	 * 
	 * @return the index at the specified position
	 */
	public OBJIndex getIndex(int index) {
		return indices.get(index);
	}

	/**
	 * Adds an index to this face.
	 *
	 * @param index the index to add
	 * 
	 * @return a reference to this object
	 */
	public OBJFace addIndex(OBJIndex index) {
		indices.add(index);
		return this;
	}

	/**
	 * Removes the index at the specified position.
	 *
	 * @param index the position of the index to remove
	 * 
	 * @return a reference to this object
	 */
	public OBJFace removeIndex(int index) {
		indices.remove(index);
		return this;
	}

	/**
	 * Removes the specified index from this face.
	 *
	 * @param index the index to remove
	 * 
	 * @return a reference to this object
	 */
	public OBJFace removeIndex(OBJIndex index) {
		indices.remove(index);
		return this;
	}

	/**
	 * Clears all indices from this face.
	 *
	 * @return a reference to this object
	 */
	public OBJFace clearIndices() {
		indices.clear();
		return this;
	}

	/**
	 * Returns the number of indices in the object.
	 * 
	 * @return number of indices
	 */
	public int getIndexCount() {
		return indices.size();
	}

	/**
	 * Converts the face to its OBJ string representation.
	 *
	 * @return the OBJ string representation of this face
	 */
	@Override
	public String toOBJString() {
		return new StringBuilder().append("f ").append(indices.stream()//
				.map(OBJIndex::toOBJString).collect(Collectors.joining(" "))).toString();
	}

	@Override
	public String toString() {
		return String.format("OBJFace [indices=%s]", indices);
	}

}
