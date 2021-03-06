/************ Update: Schemas ***************/


/************ Add: Sequences ***************/

/* Autogenerated Sequences */

CREATE SEQUENCE "public"."Bodegas_idBodegas_seq" INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE "public"."Bodegas_idBodegas_seq" IS 'DbWrench Autogenerated Sequence.';

CREATE SEQUENCE "public"."Categorias_idCategoria_seq" INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE "public"."Categorias_idCategoria_seq" IS 'DbWrench Autogenerated Sequence.';

CREATE SEQUENCE "public"."Menus_idMenu_seq" INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE "public"."Menus_idMenu_seq" IS 'DbWrench Autogenerated Sequence.';

CREATE SEQUENCE "public"."Perfiles_idPerfil_seq" INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE "public"."Perfiles_idPerfil_seq" IS 'DbWrench Autogenerated Sequence.';

CREATE SEQUENCE "public"."Productos_idProducto_seq" INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE "public"."Productos_idProducto_seq" IS 'DbWrench Autogenerated Sequence.';

CREATE SEQUENCE "public"."Seguimientos_idSeguimiento_seq" INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE "public"."Seguimientos_idSeguimiento_seq" IS 'DbWrench Autogenerated Sequence.';

CREATE SEQUENCE "public"."TipoProductos_idTipoProducto_seq" INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE "public"."TipoProductos_idTipoProducto_seq" IS 'DbWrench Autogenerated Sequence.';

CREATE SEQUENCE "public"."Users_idUser_seq" INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE "public"."Users_idUser_seq" IS 'DbWrench Autogenerated Sequence.';




/************ Update: Tables ***************/

/******************** Add Table: "public"."Bodegas" ************************/

/* Build Table Structure */
CREATE TABLE "public"."Bodegas"
(
	"idBodegas" INTEGER DEFAULT nextval('public."Bodegas_idBodegas_seq"'::regclass) NOT NULL,
	nombre VARCHAR(100) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "public"."Bodegas" ADD CONSTRAINT "pkBodegas"
	PRIMARY KEY ("idBodegas");


/******************** Add Table: "public"."Bodegas_has_Productos" ************************/

/* Build Table Structure */
CREATE TABLE "public"."Bodegas_has_Productos"
(
	"idProducto" INTEGER NOT NULL,
	"idBodegas" INTEGER NOT NULL
);


/******************** Add Table: "public"."Categorias" ************************/

/* Build Table Structure */
CREATE TABLE "public"."Categorias"
(
	"idCategoria" INTEGER DEFAULT nextval('public."Categorias_idCategoria_seq"'::regclass) NOT NULL,
	nombre VARCHAR(100) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "public"."Categorias" ADD CONSTRAINT "pkCategorias"
	PRIMARY KEY ("idCategoria");


/******************** Add Table: "public"."Menus" ************************/

/* Build Table Structure */
CREATE TABLE "public"."Menus"
(
	"idMenu" INTEGER DEFAULT nextval('public."Menus_idMenu_seq"'::regclass) NOT NULL,
	"idPerfil" INTEGER NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	url VARCHAR(200) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "public"."Menus" ADD CONSTRAINT "pkMenus"
	PRIMARY KEY ("idMenu");


/******************** Add Table: "public"."Pedido_has_Productos" ************************/

/* Build Table Structure */
CREATE TABLE "public"."Pedido_has_Productos"
(
	"idPedido" INTEGER NOT NULL,
	"idProducto" INTEGER NOT NULL,
	cantidad INTEGER NOT NULL
);


/******************** Add Table: "public"."Pedidos" ************************/

/* Build Table Structure */
CREATE TABLE "public"."Pedidos"
(
	"idPedido" INTEGER NOT NULL,
	"idUser" INTEGER NOT NULL,
	"fechaCreacion" TIMESTAMP NOT NULL,
	"totalProductos" INTEGER NOT NULL
);

/* Add Primary Key */
ALTER TABLE "public"."Pedidos" ADD CONSTRAINT "pkPedidos"
	PRIMARY KEY ("idPedido");


/******************** Add Table: "public"."Perfiles" ************************/

/* Build Table Structure */
CREATE TABLE "public"."Perfiles"
(
	"idPerfil" INTEGER DEFAULT nextval('public."Perfiles_idPerfil_seq"'::regclass) NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	descripcion VARCHAR(200) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "public"."Perfiles" ADD CONSTRAINT "pkPerfiles"
	PRIMARY KEY ("idPerfil");


/******************** Add Table: "public"."Productos" ************************/

/* Build Table Structure */
CREATE TABLE "public"."Productos"
(
	"idProducto" INTEGER DEFAULT nextval('public."Productos_idProducto_seq"'::regclass) NOT NULL,
	"idTipoProducto" INTEGER NOT NULL,
	"idCategoria" INTEGER NOT NULL,
	descripcion VARCHAR(200) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "public"."Productos" ADD CONSTRAINT "pkProductos"
	PRIMARY KEY ("idProducto");


/******************** Add Table: "public"."Seguimientos" ************************/

/* Build Table Structure */
CREATE TABLE "public"."Seguimientos"
(
	"idSeguimiento" INTEGER DEFAULT nextval('public."Seguimientos_idSeguimiento_seq"'::regclass) NOT NULL,
	"idPedido" INTEGER NOT NULL,
	"fechaInicioPreparacion" TIMESTAMP NULL,
	"fechaFinPreparacion" TIMESTAMP NULL,
	"fechaEstimadaEnvio" TIMESTAMP NULL,
	"fechaEnvio" TIMESTAMP NULL,
	"trackingNumber" VARCHAR(50) NULL,
	estado VARCHAR(50) NULL
);

/* Add Primary Key */
ALTER TABLE "public"."Seguimientos" ADD CONSTRAINT "pkSeguimientos"
	PRIMARY KEY ("idSeguimiento");


/******************** Add Table: "public"."TipoProductos" ************************/

/* Build Table Structure */
CREATE TABLE "public"."TipoProductos"
(
	"idTipoProducto" INTEGER DEFAULT nextval('public."TipoProductos_idTipoProducto_seq"'::regclass) NOT NULL,
	nombre VARCHAR(100) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "public"."TipoProductos" ADD CONSTRAINT "pkTipoProductos"
	PRIMARY KEY ("idTipoProducto");


/******************** Add Table: "public"."Users" ************************/

/* Build Table Structure */
CREATE TABLE "public"."Users"
(
	"idUser" INTEGER DEFAULT nextval('public."Users_idUser_seq"'::regclass) NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	password VARCHAR(200) NOT NULL,
	"nombreUsuario" VARCHAR(100) NOT NULL,
	correo VARCHAR(100) NOT NULL,
	"idPerfil" INTEGER NULL
);

/* Add Primary Key */
ALTER TABLE "public"."Users" ADD CONSTRAINT "pkUsers"
	PRIMARY KEY ("idUser");


/************ Add Foreign Keys ***************/

/* Add Foreign Key: fk_Bodegas_has_Productos_Bodegas */
ALTER TABLE "public"."Bodegas_has_Productos" ADD CONSTRAINT "fk_Bodegas_has_Productos_Bodegas"
	FOREIGN KEY ("idBodegas") REFERENCES "public"."Bodegas" ("idBodegas")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Bodegas_has_Productos_Productos */
ALTER TABLE "public"."Bodegas_has_Productos" ADD CONSTRAINT "fk_Bodegas_has_Productos_Productos"
	FOREIGN KEY ("idProducto") REFERENCES "public"."Productos" ("idProducto")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Menus_Perfiles */
ALTER TABLE "public"."Menus" ADD CONSTRAINT "fk_Menus_Perfiles"
	FOREIGN KEY ("idPerfil") REFERENCES "public"."Perfiles" ("idPerfil")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Pedido_has_Productos_Pedidos */
ALTER TABLE "public"."Pedido_has_Productos" ADD CONSTRAINT "fk_Pedido_has_Productos_Pedidos"
	FOREIGN KEY ("idPedido") REFERENCES "public"."Pedidos" ("idPedido")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Pedido_has_Productos_Productos */
ALTER TABLE "public"."Pedido_has_Productos" ADD CONSTRAINT "fk_Pedido_has_Productos_Productos"
	FOREIGN KEY ("idProducto") REFERENCES "public"."Productos" ("idProducto")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Pedidos_Users */
ALTER TABLE "public"."Pedidos" ADD CONSTRAINT "fk_Pedidos_Users"
	FOREIGN KEY ("idUser") REFERENCES "public"."Users" ("idUser")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Productos_Categorias */
ALTER TABLE "public"."Productos" ADD CONSTRAINT "fk_Productos_Categorias"
	FOREIGN KEY ("idCategoria") REFERENCES "public"."Categorias" ("idCategoria")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Productos_TipoProductos */
ALTER TABLE "public"."Productos" ADD CONSTRAINT "fk_Productos_TipoProductos"
	FOREIGN KEY ("idTipoProducto") REFERENCES "public"."TipoProductos" ("idTipoProducto")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Seguimientos_Pedidos */
ALTER TABLE "public"."Seguimientos" ADD CONSTRAINT "fk_Seguimientos_Pedidos"
	FOREIGN KEY ("idPedido") REFERENCES "public"."Pedidos" ("idPedido")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Users_Perfiles */
ALTER TABLE "public"."Users" ADD CONSTRAINT "fk_Users_Perfiles"
	FOREIGN KEY ("idPerfil") REFERENCES "public"."Perfiles" ("idPerfil")
	ON UPDATE NO ACTION ON DELETE NO ACTION;