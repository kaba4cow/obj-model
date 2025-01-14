# OBJ Model Library

A lightweight **Java** library designed for parsing and manipulating 3D models in the **[Wavefront OBJ](https://en.wikipedia.org/wiki/Wavefront_.obj_file)** format. It provides a flexible and extensible API for handling vertices, normals, texture coordinates, and faces in a structured way.

## Features

- Limited but still useful OBJ data parsing
- Easy-to-use methods for manipulating the model data

## Limitations

While the OBJModel library provides a robust foundation for working with Wavefront OBJ files, it currently supports only a subset of the full OBJ file specification. Specifically, the library is designed to handle:

- Comments (`#`)
- Objects (`o`)
- Vertices (`v`)
- Texture coords (`vt`)
- Normals (`vn`)
- Faces (`f`)

Other features such as materials, object groups, curves, advanced object properties, etc. are not supported at the moment. Future updates may expand support for these features, but for now, the library focuses on the most essential aspects of the OBJ format, providing a simple and effective way to work with the core data structures in 3D models.

**Note**: If the parser encounters an unsupported element, it does not throw an error. However, this may lead to unexpected behavior depending on how the unsupported elements interact with the rest of the data. Users are advised to ensure that their OBJ files only contain supported elements or handle any unsupported parts separately to avoid issues.

## Usage

### Parsing an OBJ

```java
OBJModel model = new OBJModel(source);
```

or

```java
OBJModel model = OBJParser.parse(source, null);
```

The `source` can be either a `Reader`, an `InputStream` or a `String`.

### Converting to OBJ data

```java
String obj = model.toOBJString();
System.out.println(obj);
```

### Building an OBJ model

```java
OBJModel model = new OBJModel();
model.addComment(new OBJComment().setText("This is a comment"));

OBJObject object = new OBJObject().setName("Model")//
		.addVertex(new OBJVertex().set(1.0f, 0.0f, 0.0f))//
		.addVertex(new OBJVertex().set(0.0f, 1.0f, 0.0f))//
		.addVertex(new OBJVertex().set(1.0f, 1.0f, 1.0f))//

		.addNormal(new OBJNormal().set(1.0f, 0.0f, 0.0f))//
		.addNormal(new OBJNormal().set(0.0f, 1.0f, 0.0f))//
		.addNormal(new OBJNormal().set(1.0f, 1.0f, 1.0f))//

		.addTexture(new OBJTexture().set(1.0f, 0.0f))//
		.addTexture(new OBJTexture().set(0.0f, 1.0f))//
		.addTexture(new OBJTexture().set(1.0f, 1.0f));
		
model.addObject(object);
OBJFace face = new OBJFace()//
		.addIndex(new OBJIndex().setVertex(0).setTexture(0).setNormal(0))//
		.addIndex(new OBJIndex().setVertex(1).setTexture(1).setNormal(1))//
		.addIndex(new OBJIndex().setVertex(2).setTexture(2).setNormal(2));
object.addFace(face);


System.out.println(model.toOBJString());
```

Output:

```obj
# Hello World!

o Model
v 1.0 0.0 0.0
v 0.0 1.0 0.0
v 1.0 1.0 1.0
vt 1.0 0.0
vt 0.0 1.0
vt 1.0 1.0
vn 1.0 0.0 0.0
vn 0.0 1.0 0.0
vn 1.0 1.0 1.0
f 1/1/1 2/2/2 3/3/3
```

### Retrieving objects from a model

```java
OBJObject modelObject = model.getObject("Model");
System.out.println(modelObject.toOBJString());
```

Output:

```obj
o Model
v 1.0 0.0 0.0
v 0.0 1.0 0.0
v 1.0 1.0 1.0
vt 1.0 0.0
vt 0.0 1.0
vt 1.0 1.0
vn 1.0 0.0 0.0
vn 0.0 1.0 0.0
vn 1.0 1.0 1.0
f 1/1/1 2/2/2 3/3/3
```