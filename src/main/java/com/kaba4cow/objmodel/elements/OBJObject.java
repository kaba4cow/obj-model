package com.kaba4cow.objmodel.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kaba4cow.objmodel.OBJElement;

/**
 * Represents an object in an OBJ model. An {@code OBJObject} contains a name and lists of vertices, textures, normals, and
 * faces, providing methods for manipulation and export to OBJ format.
 */
public class OBJObject implements OBJElement {

	private String name;
	private final List<OBJVertex> vertices;
	private final List<OBJTexture> textures;
	private final List<OBJNormal> normals;
	private final List<OBJFace> faces;

	/**
	 * Creates a new {@code OBJObject} with no name and empty lists for vertices, textures, normals, and faces.
	 */
	public OBJObject() {
		this.name = null;
		this.vertices = new ArrayList<>();
		this.textures = new ArrayList<>();
		this.normals = new ArrayList<>();
		this.faces = new ArrayList<>();
	}

	/**
	 * Retrieves the name of the object.
	 *
	 * @return the name of the object
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the object.
	 *
	 * @param name the new name of the object
	 * 
	 * @return a reference to this object
	 */
	public OBJObject setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Retrieves an unmodifiable list of vertices.
	 *
	 * @return an unmodifiable list of {@link OBJVertex} objects
	 */
	public List<OBJVertex> getVertices() {
		return Collections.unmodifiableList(vertices);
	}

	/**
	 * Retrieves a vertex by its index.
	 *
	 * @param index the index of the vertex
	 * 
	 * @return the {@link OBJVertex} at the specified index
	 */
	public OBJVertex getVertex(int index) {
		return vertices.get(index);
	}

	/**
	 * Adds a vertex to the object.
	 *
	 * @param vertex the {@link OBJVertex} to add
	 * 
	 * @return a reference to this object
	 */
	public OBJObject addVertex(OBJVertex vertex) {
		vertices.add(vertex);
		return this;
	}

	/**
	 * Removes a vertex by its index.
	 *
	 * @param index the index of the vertex to remove
	 * 
	 * @return a reference to this object
	 */
	public OBJObject removeVertex(int index) {
		vertices.remove(index);
		return this;
	}

	/**
	 * Removes a specific vertex from the object.
	 *
	 * @param vertex the {@link OBJVertex} to remove
	 * 
	 * @return a reference to this object
	 */
	public OBJObject removeVertex(OBJVertex vertex) {
		vertices.remove(vertex);
		return this;
	}

	/**
	 * Clears all vertices from the object.
	 *
	 * @return a reference to this object
	 */
	public OBJObject clearVertices() {
		vertices.clear();
		return this;
	}

	/**
	 * Retrieves an unmodifiable list of textures.
	 *
	 * @return an unmodifiable list of {@link OBJTexture} objects
	 */
	public List<OBJTexture> getTextures() {
		return Collections.unmodifiableList(textures);
	}

	/**
	 * Retrieves a texture by its index.
	 *
	 * @param index the index of the texture
	 * 
	 * @return the {@link OBJTexture} at the specified index
	 */
	public OBJTexture getTexture(int index) {
		return textures.get(index);
	}

	/**
	 * Adds a texture to the object.
	 *
	 * @param texture the {@link OBJTexture} to add
	 * 
	 * @return a reference to this object
	 */
	public OBJObject addTexture(OBJTexture texture) {
		textures.add(texture);
		return this;
	}

	/**
	 * Removes a texture by its index.
	 *
	 * @param index the index of the texture to remove
	 * 
	 * @return a reference to this object
	 */
	public OBJObject removeTexture(int index) {
		textures.remove(index);
		return this;
	}

	/**
	 * Removes a specific texture from the object.
	 *
	 * @param texture the {@link OBJTexture} to remove
	 * 
	 * @return a reference to this object
	 */
	public OBJObject removeTexture(OBJTexture texture) {
		textures.remove(texture);
		return this;
	}

	/**
	 * Clears all textures from the object.
	 *
	 * @return a reference to this object
	 */
	public OBJObject clearTextures() {
		textures.clear();
		return this;
	}

	/**
	 * Retrieves an unmodifiable list of normals.
	 *
	 * @return an unmodifiable list of {@link OBJNormal} objects
	 */
	public List<OBJNormal> getNormals() {
		return Collections.unmodifiableList(normals);
	}

	/**
	 * Retrieves a normal by its index.
	 *
	 * @param index the index of the normal
	 * 
	 * @return the {@link OBJNormal} at the specified index
	 */
	public OBJNormal getNormal(int index) {
		return normals.get(index);
	}

	/**
	 * Adds a normal to the object.
	 *
	 * @param normal the {@link OBJNormal} to add
	 * 
	 * @return a reference to this object
	 */
	public OBJObject addNormal(OBJNormal normal) {
		normals.add(normal);
		return this;
	}

	/**
	 * Removes a normal by its index.
	 *
	 * @param index the index of the normal to remove
	 * 
	 * @return a reference to this object
	 */
	public OBJObject removeNormal(int index) {
		normals.remove(index);
		return this;
	}

	/**
	 * Removes a specific normal from the object.
	 *
	 * @param normal the {@link OBJNormal} to remove
	 * 
	 * @return a reference to this object
	 */
	public OBJObject removeNormal(OBJNormal normal) {
		normals.remove(normal);
		return this;
	}

	/**
	 * Clears all normals from the object.
	 *
	 * @return a reference to this object
	 */
	public OBJObject clearNormals() {
		normals.clear();
		return this;
	}

	/**
	 * Retrieves an unmodifiable list of faces.
	 *
	 * @return an unmodifiable list of {@link OBJFace} objects
	 */
	public List<OBJFace> getFaces() {
		return Collections.unmodifiableList(faces);
	}

	/**
	 * Retrieves a face by its index.
	 *
	 * @param index the index of the face
	 * 
	 * @return the {@link OBJFace} at the specified index
	 */
	public OBJFace getFace(int index) {
		return faces.get(index);
	}

	/**
	 * Adds a face to the object.
	 *
	 * @param face the {@link OBJFace} to add
	 * 
	 * @return a reference to this object
	 */
	public OBJObject addFace(OBJFace face) {
		faces.add(face);
		return this;
	}

	/**
	 * Removes a face by its index.
	 *
	 * @param index the index of the face to remove
	 * 
	 * @return a reference to this object
	 */
	public OBJObject removeFace(int index) {
		faces.remove(index);
		return this;
	}

	/**
	 * Removes a specific face from the object.
	 *
	 * @param face the {@link OBJFace} to remove
	 * 
	 * @return a reference to this object
	 */
	public OBJObject removeFace(OBJFace face) {
		faces.remove(face);
		return this;
	}

	/**
	 * Clears all faces from the object.
	 *
	 * @return a reference to this object
	 */
	public OBJObject clearFaces() {
		faces.clear();
		return this;
	}

	/**
	 * Converts this object to its string representation in the OBJ format.
	 *
	 * @return the OBJ format string for this object
	 */
	@Override
	public String toOBJString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("o %s\n", getName()));
		vertices.stream().map(OBJElement::toOBJString).forEach(string -> builder.append(string).append("\n"));
		textures.stream().map(OBJElement::toOBJString).forEach(string -> builder.append(string).append("\n"));
		normals.stream().map(OBJElement::toOBJString).forEach(string -> builder.append(string).append("\n"));
		faces.stream().map(OBJElement::toOBJString).forEach(string -> builder.append(string).append("\n"));
		return builder.toString();
	}

	@Override
	public String toString() {
		return String.format("OBJObject [name=%s, vertices=%s, textures=%s, normals=%s, faces=%s]", name, vertices, textures,
				normals, faces);
	}

}
