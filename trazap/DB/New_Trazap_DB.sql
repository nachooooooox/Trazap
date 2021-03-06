/************ COPY/PASTE ***************/

/************ Add: Sequences ***************/

/* Autogenerated Sequences */

CREATE SEQUENCE public.bodegas_id_bodegas_seq INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE public.bodegas_id_bodegas_seq IS 'DbWrench Autogenerated Sequence.';

CREATE SEQUENCE public.categorias_id_categoria_seq INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE public.categorias_id_categoria_seq IS 'DbWrench Autogenerated Sequence.';

CREATE SEQUENCE public.menu_id_menu_seq INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE public.menu_id_menu_seq IS 'DbWrench Autogenerated Sequence.';

CREATE SEQUENCE public.perfiles_id_perfil_seq INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE public.perfiles_id_perfil_seq IS 'DbWrench Autogenerated Sequence.';

CREATE SEQUENCE public.productos_id_producto_seq INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE public.productos_id_producto_seq IS 'DbWrench Autogenerated Sequence.';

CREATE SEQUENCE public.seguimientos_id_seguimiento_seq INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE public.seguimientos_id_seguimiento_seq IS 'DbWrench Autogenerated Sequence.';

CREATE SEQUENCE public.tipo_productos_id_tipo_producto_seq INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE public.tipo_productos_id_tipo_producto_seq IS 'DbWrench Autogenerated Sequence.';

CREATE SEQUENCE public.users_id_user_seq INCREMENT BY 1 START 1;
COMMENT ON SEQUENCE public.users_id_user_seq IS 'DbWrench Autogenerated Sequence.';




/************ Update: Tables ***************/

/******************** Add Table: public.bodegas ************************/

/* Build Table Structure */
CREATE TABLE public.bodegas
(
	id_bodegas INTEGER DEFAULT nextval('public.bodegas_id_bodegas_seq'::regclass) NOT NULL,
	nombre VARCHAR(100) NOT NULL
);

/* Add Primary Key */
ALTER TABLE public.bodegas ADD CONSTRAINT pkbodegas
	PRIMARY KEY (id_bodegas);


/******************** Add Table: public.bodegas_has_productos ************************/

/* Build Table Structure */
CREATE TABLE public.bodegas_has_productos
(
	id_producto INTEGER NOT NULL,
	id_bodegas INTEGER NOT NULL
);


/******************** Add Table: public.categorias ************************/

/* Build Table Structure */
CREATE TABLE public.categorias
(
	id_categoria INTEGER DEFAULT nextval('public.categorias_id_categoria_seq'::regclass) NOT NULL,
	nombre VARCHAR(100) NOT NULL
);

/* Add Primary Key */
ALTER TABLE public.categorias ADD CONSTRAINT pkcategorias
	PRIMARY KEY (id_categoria);


/******************** Add Table: public.menu ************************/

/* Build Table Structure */
CREATE TABLE public.menu
(
	id_menu INTEGER DEFAULT nextval('public.menu_id_menu_seq'::regclass) NOT NULL,
	id_perfil INTEGER NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	url VARCHAR(200) NOT NULL
);

/* Add Primary Key */
ALTER TABLE public.menu ADD CONSTRAINT pkmenu
	PRIMARY KEY (id_menu);


/******************** Add Table: public.pedido_has_productos ************************/

/* Build Table Structure */
CREATE TABLE public.pedido_has_productos
(
	id_pedido INTEGER NOT NULL,
	id_producto INTEGER NOT NULL,
	cantidad INTEGER NOT NULL
);


/******************** Add Table: public.pedidos ************************/

/* Build Table Structure */
CREATE TABLE public.pedidos
(
	id_pedido INTEGER NOT NULL,
	id_user INTEGER NOT NULL,
	fecha_creacion TIMESTAMP NOT NULL,
	total_productos INTEGER NOT NULL
);

/* Add Primary Key */
ALTER TABLE public.pedidos ADD CONSTRAINT pkpedidos
	PRIMARY KEY (id_pedido);


/******************** Add Table: public.perfiles ************************/

/* Build Table Structure */
CREATE TABLE public.perfiles
(
	id_perfil INTEGER DEFAULT nextval('public.perfiles_id_perfil_seq'::regclass) NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	descripcion VARCHAR(200) NOT NULL
);

/* Add Primary Key */
ALTER TABLE public.perfiles ADD CONSTRAINT pkperfiles
	PRIMARY KEY (id_perfil);


/******************** Add Table: public.productos ************************/

/* Build Table Structure */
CREATE TABLE public.productos
(
	id_producto INTEGER DEFAULT nextval('public.productos_id_producto_seq'::regclass) NOT NULL,
	id_tipo_producto INTEGER NOT NULL,
	id_categoria INTEGER NOT NULL,
	descripcion VARCHAR(200) NOT NULL
);

/* Add Primary Key */
ALTER TABLE public.productos ADD CONSTRAINT pkproductos
	PRIMARY KEY (id_producto);


/******************** Add Table: public.seguimientos ************************/

/* Build Table Structure */
CREATE TABLE public.seguimientos
(
	id_seguimiento INTEGER DEFAULT nextval('public.seguimientos_id_seguimiento_seq'::regclass) NOT NULL,
	id_pedido INTEGER NOT NULL,
	fecha_inicio_preparacion TIMESTAMP NULL,
	fecha_fin_preparacion TIMESTAMP NULL,
	fecha_estimada_envio TIMESTAMP NULL,
	fecha_envio TIMESTAMP NULL,
	tracking_number VARCHAR(50) NULL,
	estado VARCHAR(50) NULL
);

/* Add Primary Key */
ALTER TABLE public.seguimientos ADD CONSTRAINT pkseguimientos
	PRIMARY KEY (id_seguimiento);


/******************** Add Table: public.tipo_productos ************************/

/* Build Table Structure */
CREATE TABLE public.tipo_productos
(
	id_tipo_producto INTEGER DEFAULT nextval('public.tipo_productos_id_tipo_producto_seq'::regclass) NOT NULL,
	nombre VARCHAR(100) NOT NULL
);

/* Add Primary Key */
ALTER TABLE public.tipo_productos ADD CONSTRAINT pktipo_productos
	PRIMARY KEY (id_tipo_producto);


/******************** Add Table: public.users ************************/

/* Build Table Structure */
CREATE TABLE public.users
(
	id_user INTEGER DEFAULT nextval('public.users_id_user_seq'::regclass) NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	password VARCHAR(200) NOT NULL,
	nombre_usuario VARCHAR(100) NOT NULL,
	correo VARCHAR(100) NOT NULL,
	id_perfil INTEGER NULL
);

/* Add Primary Key */
ALTER TABLE public.users ADD CONSTRAINT pkusers
	PRIMARY KEY (id_user);


/************ Add Foreign Keys ***************/

/* Add Foreign Key: fk_Bodegas_has_Productos_Bodegas */
ALTER TABLE public.bodegas_has_productos ADD CONSTRAINT "fk_Bodegas_has_Productos_Bodegas"
	FOREIGN KEY (id_bodegas) REFERENCES public.bodegas (id_bodegas)
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Bodegas_has_Productos_Productos */
ALTER TABLE public.bodegas_has_productos ADD CONSTRAINT "fk_Bodegas_has_Productos_Productos"
	FOREIGN KEY (id_producto) REFERENCES public.productos (id_producto)
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Menus_Perfiles */
ALTER TABLE public.menu ADD CONSTRAINT "fk_Menus_Perfiles"
	FOREIGN KEY (id_perfil) REFERENCES public.perfiles (id_perfil)
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Pedido_has_Productos_Pedidos */
ALTER TABLE public.pedido_has_productos ADD CONSTRAINT "fk_Pedido_has_Productos_Pedidos"
	FOREIGN KEY (id_pedido) REFERENCES public.pedidos (id_pedido)
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Pedido_has_Productos_Productos */
ALTER TABLE public.pedido_has_productos ADD CONSTRAINT "fk_Pedido_has_Productos_Productos"
	FOREIGN KEY (id_producto) REFERENCES public.productos (id_producto)
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Pedidos_Users */
ALTER TABLE public.pedidos ADD CONSTRAINT "fk_Pedidos_Users"
	FOREIGN KEY (id_user) REFERENCES public.users (id_user)
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Productos_Categorias */
ALTER TABLE public.productos ADD CONSTRAINT "fk_Productos_Categorias"
	FOREIGN KEY (id_categoria) REFERENCES public.categorias (id_categoria)
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Productos_TipoProductos */
ALTER TABLE public.productos ADD CONSTRAINT "fk_Productos_TipoProductos"
	FOREIGN KEY (id_tipo_producto) REFERENCES public.tipo_productos (id_tipo_producto)
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Seguimientos_Pedidos */
ALTER TABLE public.seguimientos ADD CONSTRAINT "fk_Seguimientos_Pedidos"
	FOREIGN KEY (id_pedido) REFERENCES public.pedidos (id_pedido)
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Users_Perfiles */
ALTER TABLE public.users ADD CONSTRAINT "fk_Users_Perfiles"
	FOREIGN KEY (id_perfil) REFERENCES public.perfiles (id_perfil)
	ON UPDATE NO ACTION ON DELETE NO ACTION;