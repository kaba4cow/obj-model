package com.kaba4cow.objmodel;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.kaba4cow.objmodel.elements.OBJComment;
import com.kaba4cow.objmodel.elements.OBJObject;

/**
 * Represents an OBJ model with comments and objects. This class provides functionality to parse and manipulate OBJ file data,
 * including reading from {@link Reader} or {@link String} sources.
 */
public class OBJModel {

	private final List<OBJComment> comments;
	private final List<OBJObject> objects;

	/**
	 * Creates an empty OBJ model.
	 */
	public OBJModel() {
		this.comments = new ArrayList<>();
		this.objects = new ArrayList<>();
	}

	/**
	 * Creates an OBJ model by parsing data from a {@link Reader} source.
	 *
	 * @param source a reader containing the OBJ file data
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	public OBJModel(Reader source) throws IOException {
		this();
		OBJParser.parse(source, this);
	}

	/**
	 * Creates an OBJ model by parsing data from a {@link String} source.
	 *
	 * @param source a string containing the OBJ file data
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	public OBJModel(String source) throws IOException {
		this();
		OBJParser.parse(source, this);
	}

	/**
	 * Retrieves an unmodifiable list of comments in the model.
	 *
	 * @return an unmodifiable list of {@link OBJComment} objects
	 */
	public List<OBJComment> getComments() {
		return Collections.unmodifiableList(comments);
	}

	/**
	 * Retrieves a comment from the model by its index.
	 *
	 * @param index the index of the comment
	 * 
	 * @return a reference to this object
	 */
	public OBJComment getComment(int index) {
		return comments.get(index);
	}

	/**
	 * Adds a comment to the model.
	 *
	 * @param comment the {@link OBJComment} to add
	 * 
	 * @return a reference to this object
	 */
	public OBJModel addComment(OBJComment comment) {
		comments.add(comment);
		return this;
	}

	/**
	 * Removes a comment from the model by its index.
	 *
	 * @param index the index of the comment to remove
	 * 
	 * @return a reference to this object
	 */
	public OBJModel removeComment(int index) {
		comments.remove(index);
		return this;
	}

	/**
	 * Removes a specified comment from the model.
	 *
	 * @param comment the comment to remove
	 * 
	 * @return a reference to this object
	 */
	public OBJModel removeComment(OBJComment comment) {
		comments.remove(comment);
		return this;
	}

	/**
	 * Clears all comments from the model.
	 * 
	 * @return a reference to this object
	 */
	public OBJModel clearComments() {
		comments.clear();
		return this;
	}

	/**
	 * Retrieves an unmodifiable list of objects in the model.
	 *
	 * @return an unmodifiable list of {@link OBJObject} objects
	 */
	public List<OBJObject> getObjects() {
		return Collections.unmodifiableList(objects);
	}

	/**
	 * Retrieves an object from the model by its index.
	 *
	 * @param index the index of the object
	 * 
	 * @return the {@link OBJObject} at the specified index
	 */
	public OBJObject getObject(int index) {
		return objects.get(index);
	}

	/**
	 * Retrieves an object from the model by its name.
	 *
	 * @param name the name of the object to retrieve
	 * 
	 * @return the {@link OBJObject} with the specified name, or {@code null} if not found
	 */
	public OBJObject getObject(String name) {
		for (OBJObject object : objects)
			if (Objects.equals(object.getName(), name))
				return object;
		return null;
	}

	/**
	 * Retrieves an optional object from the model by its name.
	 *
	 * @param name the name of the object to retrieve
	 * 
	 * @return the {@link Optional} containing {@link OBJObject} with the specified name
	 */
	public Optional<OBJObject> optObject(String name) {
		return Optional.ofNullable(getObject(name));
	}

	/**
	 * Adds an object to the model.
	 *
	 * @param object the {@link OBJObject} to add
	 * 
	 * @return a reference to this object
	 */
	public OBJModel addObject(OBJObject object) {
		objects.add(object);
		return this;
	}

	/**
	 * Removes an object from the model by its index.
	 *
	 * @param index the index of the object to remove
	 * 
	 * @return a reference to this object
	 */
	public OBJModel removeObject(int index) {
		objects.remove(index);
		return this;
	}

	/**
	 * Removes a specified object from the model.
	 *
	 * @param object the object to remove
	 * 
	 * @return a reference to this object
	 */
	public OBJModel removeObject(OBJObject object) {
		objects.remove(object);
		return this;
	}

	/**
	 * Clears all objects from the model.
	 * 
	 * @return a reference to this object
	 */
	public OBJModel clearObjects() {
		objects.clear();
		return this;
	}

	/**
	 * Converts the model to a string representation in OBJ format.
	 *
	 * @return a string representation of this model in OBJ format
	 */
	public String toOBJString() {
		StringBuilder builder = new StringBuilder();
		if (!comments.isEmpty()) {
			comments.stream().map(OBJElement::toOBJString).forEach(string -> builder.append(string).append("\n"));
			builder.append("\n");
		}
		if (!objects.isEmpty()) {
			objects.stream().map(OBJElement::toOBJString).forEach(string -> builder.append(string).append("\n"));
			builder.append("\n");
		}
		return builder.toString();
	}

	/**
	 * Returns a string representation of the model, including its comments and objects.
	 *
	 * @return a string representation of this model
	 */
	@Override
	public String toString() {
		return String.format("OBJModel [comments=%s, objects=%s]", comments, objects);
	}

}
