package com.kaba4cow.objmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Objects;

import com.kaba4cow.objmodel.elements.OBJComment;
import com.kaba4cow.objmodel.elements.OBJFace;
import com.kaba4cow.objmodel.elements.OBJIndex;
import com.kaba4cow.objmodel.elements.OBJNormal;
import com.kaba4cow.objmodel.elements.OBJObject;
import com.kaba4cow.objmodel.elements.OBJTexture;
import com.kaba4cow.objmodel.elements.OBJVertex;

/**
 * A utility class for reading OBJ data from {@link Reader} or strings and converting it to {@link OBJModel} objects.
 */
public class OBJParser {

	private OBJParser() {}

	/**
	 * Reads the OBJ data from the specified {@link Reader} and converts its contents to an {@link OBJModel} object. If the
	 * {@code target} is not {@code null} its contents are cleared using {@link OBJModel#clearComments()} and
	 * {@link OBJModel#clearObjects()}
	 * 
	 * @param source the {@link Reader} to read the OBJ data from
	 * @param target the {@link OBJModel} to convert the OBJ data to, or {@code null}
	 * 
	 * @return the {@link OBJModel} containing the data, either the passed one or a newly created one if {@code target} is
	 *             {@code null}
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	public static OBJModel parse(Reader source, OBJModel target) throws IOException {
		Objects.requireNonNull(source, "Source must not be null");
		if (Objects.isNull(target))
			target = new OBJModel();
		else
			target.clearComments().clearObjects();
		OBJObject object = null;
		BufferedReader reader = new BufferedReader(source);
		String line;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.isEmpty())
				continue;
			String[] parts = line.split("\\s+");
			if (parts.length > 1)
				switch (parts[0]) {
					case "#":
						target.addComment(new OBJComment().setText(line.split("\\s+", 2)[1]));
						break;
					case "o":
						if (Objects.nonNull(object))
							target.addObject(object);
						object = new OBJObject().setName(parts[1]);
						break;
					case "v":
						if (Objects.nonNull(object)) {
							OBJVertex vertex = new OBJVertex();
							vertex.set(Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), Float.parseFloat(parts[3]));
							object.addVertex(vertex);
						}
						break;
					case "vt":
						if (Objects.nonNull(object)) {
							OBJTexture texture = new OBJTexture();
							if (parts.length > 3)
								texture.set(Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), Float.parseFloat(parts[3]));
							else if (parts.length > 2)
								texture.set(Float.parseFloat(parts[1]), Float.parseFloat(parts[2]));
							object.addTexture(texture);
						}
						break;
					case "vn":
						if (Objects.nonNull(object)) {
							OBJNormal normal = new OBJNormal();
							normal.set(Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), Float.parseFloat(parts[3]));
							object.addNormal(normal);
						}
						break;
					case "f":
						if (Objects.nonNull(object)) {
							OBJFace face = new OBJFace();
							for (int i = 1; i < parts.length; i++) {
								String[] indices = parts[i].split("/");
								OBJIndex index = new OBJIndex();
								index.setVertex(Integer.parseInt(indices[0]) - 1);
								if (indices.length > 1 && !indices[1].isEmpty())
									index.setTexture(Integer.parseInt(indices[1]) - 1);
								if (indices.length > 2 && !indices[2].isEmpty())
									index.setNormal(Integer.parseInt(indices[2]) - 1);
								face.addIndex(index);
							}
							object.addFace(face);
						}
						break;
					default:
						break;
				}
		}
		if (Objects.nonNull(object))
			target.addObject(object);
		reader.close();
		return target;
	}

	/**
	 * Reads the OBJ data from the specified string and converts its contents to an {@link OBJModel} object. If the
	 * {@code target} is not {@code null} its contents are cleared using {@link OBJModel#clearComments()} and
	 * {@link OBJModel#clearObjects()}
	 * 
	 * @param source the string to read the OBJ data from
	 * @param target the {@link OBJModel} to convert the OBJ data to, or {@code null}
	 * 
	 * @return the {@link OBJModel} containing the data, either the passed one or a newly created one if {@code target} is
	 *             {@code null}
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	public static OBJModel parse(String source, OBJModel target) throws IOException {
		return parse(new StringReader(source), target);
	}

}
