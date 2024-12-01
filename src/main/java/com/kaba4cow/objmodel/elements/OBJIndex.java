package com.kaba4cow.objmodel.elements;

import java.util.Objects;

import com.kaba4cow.objmodel.OBJElement;

/**
 * Represents an index set in a face. Its indices refer to a vertex, texture and a normal indices in an OBJ object.
 */
public class OBJIndex implements OBJElement {

	private Integer vertex;
	private Integer texture;
	private Integer normal;

	/**
	 * Creates an empty index.
	 */
	public OBJIndex() {
		this.vertex = null;
		this.texture = null;
		this.normal = null;
	}

	/**
	 * Returns the vertex index.
	 *
	 * @return the vertex index
	 * 
	 * @throws NullPointerException if the vertex index is not set
	 */
	public int getVertex() {
		return vertex;
	}

	/**
	 * Sets the vertex index.
	 *
	 * @param vertex the vertex index
	 * 
	 * @return a reference to this object
	 */
	public OBJIndex setVertex(int vertex) {
		this.vertex = vertex;
		return this;
	}

	/**
	 * Clears the vertex index.
	 *
	 * @return a reference to this object
	 */
	public OBJIndex clearVertex() {
		this.vertex = null;
		return this;
	}

	/**
	 * Checks if the vertex index is set.
	 *
	 * @return {@code true} if the vertex index is set, {@code false} otherwise
	 */
	public boolean hasVertex() {
		return Objects.nonNull(texture);
	}

	/**
	 * Returns the texture index.
	 *
	 * @return the texture index
	 * 
	 * @throws NullPointerException if the texture index is not set
	 */
	public int getTexture() {
		return texture;
	}

	/**
	 * Sets the texture index.
	 *
	 * @param texture the texture index
	 * 
	 * @return a reference to this object
	 */
	public OBJIndex setTexture(int texture) {
		this.texture = texture;
		return this;
	}

	/**
	 * Clears the texture index.
	 *
	 * @return a reference to this object
	 */
	public OBJIndex clearTexture() {
		this.texture = null;
		return this;
	}

	/**
	 * Checks if the texture index is set.
	 *
	 * @return {@code true} if the texture index is set, {@code false} otherwise
	 */
	public boolean hasTexture() {
		return Objects.nonNull(texture);
	}

	/**
	 * Returns the normal index.
	 *
	 * @return the normal index
	 * 
	 * @throws NullPointerException if the normal index is not set
	 */
	public int getNormal() {
		return normal;
	}

	/**
	 * Sets the normal index.
	 *
	 * @param normal the normal index
	 * 
	 * @return a reference to this object
	 */
	public OBJIndex setNormal(int normal) {
		this.normal = normal;
		return this;
	}

	/**
	 * Clears the normal index.
	 *
	 * @return a reference to this object
	 */
	public OBJIndex clearNormal() {
		this.normal = null;
		return this;
	}

	/**
	 * Checks if the normal index is set.
	 *
	 * @return {@code true} if the normal index is set, {@code false} otherwise
	 */
	public boolean hasNormal() {
		return Objects.nonNull(normal);
	}

	/**
	 * Clears the vertex, texture and normal indices.
	 *
	 * @return a reference to this object
	 */
	public OBJIndex clearIndices() {
		return clearVertex().clearTexture().clearNormal();
	}

	/**
	 * Converts the index to its OBJ string representation.
	 *
	 * @return the OBJ string representation of this index
	 */
	@Override
	public String toOBJString() {
		Objects.requireNonNull(vertex, "Vertex must not be empty");
		StringBuilder builder = new StringBuilder();
		builder.append(vertex + 1);
		if (Objects.nonNull(texture))
			builder.append("/").append(texture + 1);
		else if (Objects.nonNull(normal))
			builder.append("/");
		if (Objects.nonNull(normal))
			builder.append("/").append(normal + 1);
		return builder.toString();
	}

	@Override
	public String toString() {
		return String.format("OBJIndex [vertex=%s, texture=%s, normal=%s]", vertex, texture, normal);
	}

}
