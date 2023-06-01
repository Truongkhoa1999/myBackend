--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


--
-- Name: uuid-ossp; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;


--
-- Name: EXTENSION "uuid-ossp"; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: cart; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cart (
    cart_id uuid NOT NULL,
    price integer NOT NULL,
    product_id uuid,
    quantity integer NOT NULL,
    title character varying(255) NOT NULL,
    user_id uuid
);


ALTER TABLE public.cart OWNER TO postgres;

--
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    category_id uuid NOT NULL,
    title character varying(100) NOT NULL
);


ALTER TABLE public.category OWNER TO postgres;

--
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    id uuid NOT NULL,
    avatar character varying(200) NOT NULL,
    first_name character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role character varying(255) NOT NULL,
    username character varying(255)
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id uuid NOT NULL,
    brand character varying(100) NOT NULL,
    description character varying(200) NOT NULL,
    is_removed boolean NOT NULL,
    price numeric(10,2) NOT NULL,
    quantity integer NOT NULL,
    thumbnail character varying(200) NOT NULL,
    title character varying(100) NOT NULL,
    category_category_id uuid NOT NULL,
    statics_stat_id uuid
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Name: product_images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_images (
    product_id uuid NOT NULL,
    images character varying(255) NOT NULL
);


ALTER TABLE public.product_images OWNER TO postgres;

--
-- Name: statics; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.statics (
    stat_id uuid NOT NULL,
    clicks integer DEFAULT 0,
    created_at timestamp(6) without time zone,
    rating integer DEFAULT 0
);


ALTER TABLE public.statics OWNER TO postgres;

--
-- Data for Name: cart; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cart (cart_id, price, product_id, quantity, title, user_id) FROM stdin;
f63a3676-8fd2-44bf-99d5-d87cf64a7aad	55	3d255fb2-da22-40b8-87d6-37c4e50dc40e	1	Streamplify MIC TRIPOD microphone	c685a0ca-959a-405c-801b-af44c78da46a
ac5e77d0-f934-4c47-84bc-9799d9acb1d9	459	200814b3-4da8-4c44-8c3f-68ac3069c3ab	1	noblechairs EPIC Gaming Chair - Spider-Man Special Edition	55ebe489-ec69-4a12-9653-c9c3d531b78d
5aeb0723-de93-4287-a5eb-4f8b99642549	200	1714ae45-33d8-4e2a-a2b7-8b6d1066de62	1	Ducky One 3 Daybreak, mechanical keyboard, Cherry MX Clear, black	55ebe489-ec69-4a12-9653-c9c3d531b78d
95a09b4b-1697-462e-8bc6-9bddeee2ae30	459	200814b3-4da8-4c44-8c3f-68ac3069c3ab	1	noblechairs EPIC Gaming Chair - Spider-Man Special Edition	55ebe489-ec69-4a12-9653-c9c3d531b78d
8c665392-d5a8-4dc4-beaf-fc0b6e92fed9	200	1714ae45-33d8-4e2a-a2b7-8b6d1066de62	0	Ducky One 3 Daybreak, mechanical keyboard, Cherry MX Clear, black	55ebe489-ec69-4a12-9653-c9c3d531b78d
\.


--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.category (category_id, title) FROM stdin;
594e004c-2644-42a5-a7f7-764a34ca87f7	Motherboard
5091ffff-8adb-489c-95b5-c57662c73c56	Smartphone
858bc29b-073d-4e00-8af2-2e0f6813392d	Peripherals
ed0bb29e-bebb-4119-a6b9-951aea69d0f0	Component
d2cb875e-e42e-4827-bbdc-c94c8216ebe7	Furniture
\.


--
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (id, avatar, first_name, password, role, username) FROM stdin;
c685a0ca-959a-405c-801b-af44c78da46a	https://variety.com/wp-content/uploads/2022/11/Screen-Shot-2022-11-02-at-8.33.52-AM.png	Khoa	$2a$10$188KESWhEzbHWCIWiiivk.tr6ggQPhfWFbHC7PV2OP10swZJpM5nO	ADMIN	admin
1e512d7d-94d6-49eb-8e46-ec1669b2ff16	https://static.wikia.nocookie.net/jamescameronsavatar/images/e/e5/Avatar_TWoW_Neytiri_Textless_Poster.jpg/revision/latest?cb=20221125232909	Truong	$2a$10$PfQW5FJ0BEOs2b5.omqUTe8TxmYG0ZsPDFf2IM7f6o/3FWRzBYoUG	USER	khoa
9949bf4f-1a87-4c95-a7fe-b2ffce0b55b5	https://gray-wgcl-prod.cdn.arcpublishing.com/resizer/m_-nP-tPuvsbYczJh8lnT7uGMmA=/1200x675/smart/filters:quality(85)/cloudfront-us-east-1.images.arcpublishing.com/gray/YZLZHT6NHRARVGZYCDMGIFK4VM.jpg	Dang	$2a$10$YVHYdn6hS9HxpVAE3MpyGebUgRyb8sIgAmTHjDLqxpoixM3fP8y2C	USER	dang
0f02e96c-b7d0-42f5-b917-5c233945dba6	https://poy.time.com/wp-content/uploads/sites/11/2012/12/2012_poy_main_lede.jpg?w=753	Truong2	$2a$10$w1Ysoi/m6Wvp43qN9jBZ8uoZJqfISfnlDA.YR6xco08O9QlCIjy52	USER	truong
15910218-a5d1-4079-833a-50ffa9fe43ff	https://flxt.tmsimg.com/assets/p186109_b_v8_aa.jpg	Khoa	$2a$10$Svn6QQ8A4PyklHhDBlTgx.Z.l1iMK4piNEzW9IvIt8MbcK8VyQLz2	USER	khoa3
202c017f-d68b-4346-a92c-c751dd8ab905	https://www.looper.com/img/gallery/the-ending-of-avatar-finally-explained/intro-1669817126.jpg	Khoa	$2a$10$C3.Bwza.y/h6wAEA2C0Hp.OLU65cbYIvCwtsppzUUvM/MsaqdzF3O	USER	khoa2
55ebe489-ec69-4a12-9653-c9c3d531b78d	https://upload.wikimedia.org/wikipedia/commons/f/f1/Atkinson_Rowan.jpg	Dang	$2a$10$heUR0JtR5AS2pfO.QXOm9O9weichBFiwQ6ihLlk2AMaxms6mkaZXS	USER	khoa4
\.


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (id, brand, description, is_removed, price, quantity, thumbnail, title, category_category_id, statics_stat_id) FROM stdin;
8e464bac-b941-4b69-82d3-637e6e3fdc4c	Sennheiser	The open HD 599 headphones deliver an impressively natural performance in terms of space. Acting as the top model of the 500 series	f	158.00	61	https://ic.jimms.fi/product/4/4/146845-ig800gg.jpg	Sennheiser HD 599, replaces surround High End headphones	858bc29b-073d-4e00-8af2-2e0f6813392d	ee1c206a-d38b-43f9-bbcb-c0ee6fbae2f3
210e2ba9-98ff-4650-b833-5e3cf83bcfa6	Apple	XV242Y PSize 23.8 Maximum resolution and refresh 165	f	799.00	0	https://ic.jimms.fi/product/6/4/352765-ig800gg.jpg	Apple iPhone 13 128GB, blue	5091ffff-8adb-489c-95b5-c57662c73c56	49d9f33c-8e66-4bff-979d-04fb1ea34713
3d255fb2-da22-40b8-87d6-37c4e50dc40e	Streamplify	Model: MIC TRIPODSensor type: Ø16 mm condenser CapsuleCondenser quantity: 1Sound sampling pattern: Cardioid	f	55.00	20	https://ic.jimms.fi/product/2/3/365926-ig800gg.jpg	Streamplify MIC TRIPOD microphone	858bc29b-073d-4e00-8af2-2e0f6813392d	785a5a99-30eb-4814-8e10-7ba693cfa3c8
6fc1422b-9d7f-42db-abb7-98ebc9684a07	Corsair	Compact SFX-L form factor Fully modular, Micro-Fit connectors on the end of the power supply Intel ATX 3.0 certified	f	279.00	0	https://ic.jimms.fi/product/8/7/441482-ig800gg.jpg	Corsair 1000W SF1000L, SFX-L power supply	ed0bb29e-bebb-4119-a6b9-951aea69d0f0	539b2e25-cfc3-4734-8261-bda33a794787
34fe477a-2ede-4e77-90e9-e7afeca9392c	Acer	XV242Y PSize 23.8 Maximum resolution and refresh 165	f	169.00	0	https://ic.jimms.fi/product/8/6/431883-ig800gg.jpg	Acer XV242Y Full HD monitor	858bc29b-073d-4e00-8af2-2e0f6813392d	f9036a28-d7af-4783-95c6-cdc2646b98f5
200814b3-4da8-4c44-8c3f-68ac3069c3ab	Noble	YOUR NEIGHBORHOOD FRIEND SPIDER-MAN BRINGS STYLE TO YOUR WORKPLACEUnleash your hero powers without being.	f	459.00	20	https://ic.jimms.fi/product/8/9/366980-ig800gg.jpg	noblechairs EPIC Gaming Chair - Spider-Man Special Edition	d2cb875e-e42e-4827-bbdc-c94c8216ebe7	e9de3927-1d8b-4ce6-bf8c-5fe2086edfa4
9028f02a-d787-43a4-8feb-1096fd950b2f	Noble	Land on the paradise island of Yara and prepare to face the ruthless dictator Antón El Presidente Castillo. 	f	449.00	9	https://ic.jimms.fi/product/7/2/355577-ig800gg.jpg	noblechairs HERO Gaming Chair - Far Cry 6 Special Edition	d2cb875e-e42e-4827-bbdc-c94c8216ebe7	476acf91-41cb-4313-84da-0371fa652fcf
1714ae45-33d8-4e2a-a2b7-8b6d1066de62	Ducky	Ducky One 3's keycaps are made of durable PBT plastic by fusing two layers of plastic together, so the character set of the keycaps 	f	200.00	0	https://ic.jimms.fi/product/2/3/395126-ig800gg.jpg	Ducky One 3 Daybreak, mechanical keyboard, Cherry MX Clear, black	858bc29b-073d-4e00-8af2-2e0f6813392d	ec52b28a-f75a-44c1-880d-d440f1564ed9
ee9f2726-aea9-4078-80fc-0e7a99520769	Noble	With the new synchronized mechanism, we offer users even more ergonomics and adjustment possibilities than before. Whether it's a long day at the office, studying at the.	f	388.00	43	https://ic.jimms.fi/product/7/5/349574-ig800gg.jpg	noblechairs EPIC Compact Gaming Chair	d2cb875e-e42e-4827-bbdc-c94c8216ebe7	2b85bb9e-9743-4a87-b024-d889326c602c
97269565-5557-4c9e-8131-ab60fb5a6d89	MSI	NVIDIA® GeForce RTX® 40 series graphics processors offer gamers and creative workers much more than super-fast graphics. Their power comes from the ultra-efficient NVIDIA Ada Lovelace architecture	f	759.00	0	https://ic.jimms.fi/product/2/5/438224-ig800gg.jpg	MSI GeForce RTX 4070 GAMING X TRIO	ed0bb29e-bebb-4119-a6b9-951aea69d0f0	f0c36f92-23ec-4eef-adaf-fdd9bf89add7
23ace5af-b7d3-494b-80e9-608e79991222	Xerox	Media types supported: Envelopes, plain paper,labels, recycled paper	f	429.00	15	https://ic.jimms.fi/product/7/3/347176-ig800gg.jpg	Xerox C235, color laser multifunction device, A4	858bc29b-073d-4e00-8af2-2e0f6813392d	6da1b3f7-499f-4892-8db4-7592f57c9bb6
dddd3cc8-f770-48aa-bdfd-df99646a1929	EZVIZ	The camera captures more details than standard fixed cameras, so this camera offers reliable and wide-area protection. When you connect the camera with the EZVIZ application	f	200.00	90	https://ic.jimms.fi/product/0/5/427904-ig800gg.jpg	EZVIZ H8c Outdoor Pan/Tilt Camera WiFi	858bc29b-073d-4e00-8af2-2e0f6813392d	4f5dff77-8a93-43a7-a6aa-76cb29f2bec3
881e7d4b-2a8a-4f2e-8c49-20f489c8ef81	Ducky	Dimensions (LxWxH) : approx. 124 x 59 x 36 mm Weight : approx. 65 g Color : Black, white	f	70.00	75	https://ic.jimms.fi/product/9/1/365498-ig800gg.jpg	Ducky Feather Gaming Mouse, ARGB,	858bc29b-073d-4e00-8af2-2e0f6813392d	9bab2f25-7e14-45b8-8ab0-0526ee37cb9c
44611cda-2b8d-4a7c-9f9e-9c1c523dc8d9	Ducky	Ducky One 3's keycaps are made of durable PBT plastic by fusing two layers of plastic together	f	160.00	25	https://ic.jimms.fi/product/8/4/395185-ig800gg.jpg	Ducky One 3 SF Yellow, mechanical keyboard, 65%, Cherry MX Clear	858bc29b-073d-4e00-8af2-2e0f6813392d	29fb4792-9436-42b4-805b-1032c42bff2a
e15db7fe-6bc4-44dd-8a82-12c26051d141	Asus	In Jimm's End Of School sale, you can find gift ideas for the newly graduated, as well as other current products for both home office and free time.	f	79.00	25	https://ic.jimms.fi/product/1/2/441617-ig800gg.jpg	Asus Prime AP201	ed0bb29e-bebb-4119-a6b9-951aea69d0f0	12cd6ec7-7c68-461f-86ac-b9be229a4593
432f5e05-daf0-4645-874c-58ce449b896b	Intel	In Jimm's End Of School sale, you can find gift ideas for the newly graduated, as well as other current products for both home office and free time.	f	600.00	20	https://ic.jimms.fi/product/5/3/444956-ig800gg.jpg	Intel Core i9-13900K, LGA1700, 3.00 GHz, 36MB,	858bc29b-073d-4e00-8af2-2e0f6813392d	d14af3bb-63aa-467d-a071-cf87fd40f0dc
1a322a50-9a14-4f21-bbd6-1a5900fc3cf7	Razer	A camera designed for desktop use / streaming with a multi-phase light ring	f	100.00	12	https://ic.jimms.fi/product/2/6/185423-ig800gg.jpg	Razer Kiyo webcam, black/white	858bc29b-073d-4e00-8af2-2e0f6813392d	2e480d5d-335d-4da2-b54b-ee52ec0b5bcc
b061b77a-c8a5-4703-b4bc-37948f4ff344	Ducky	All Ducky One 2 Mini keyboards come with 10 extra colorful PBT Double-shot keycaps (the package contains random colors and we cannot control the color of the additional keys supplied	f	225.00	72	https://ic.jimms.fi/product/2/5/282124-ig800gg.jpg	Ducky One 2 Mini 2020, mechanical keyboard,	858bc29b-073d-4e00-8af2-2e0f6813392d	50296d41-04f7-490a-8d8d-6e3a82d83b66
ed3308fb-9f58-49e0-8d5e-61816be89f74	Gigabyte	Processor support LGA1700 base Supports 13th and 12th generation Intel Core, Pentium Gold and Celeron processors	f	225.00	6	https://ic.jimms.fi/product/9/8/421891-ig800gg.jpg	Gigabyte B760I AORUS PRO DDR4, Mini-ITX motherboard	ed0bb29e-bebb-4119-a6b9-951aea69d0f0	26182c5b-dcd6-42ef-a8ce-e91c0292c783
c9fb8e94-0fb4-440f-8922-c02675f25b2e	Apple	Size or shape: Touch Protection: Dustproof, splashproof, waterproo	f	1650.00	12	https://ic.jimms.fi/product/2/0/403329-ig800gg.jpg	Apple iPhone 14 Pro Max, 5G smartphone, 256GB, dark purple	5091ffff-8adb-489c-95b5-c57662c73c56	bcd80285-db2b-49c8-8420-351ae1a23e46
\.


--
-- Data for Name: product_images; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product_images (product_id, images) FROM stdin;
ed3308fb-9f58-49e0-8d5e-61816be89f74	https://ic.jimms.fi/product/9/7/421892-ig800gg.jpg
ed3308fb-9f58-49e0-8d5e-61816be89f74	https://ic.jimms.fi/product/9/6/421893-ig800gg.jpg
ed3308fb-9f58-49e0-8d5e-61816be89f74	https://ic.jimms.fi/product/9/5/421894-ig800gg.jpg
ed3308fb-9f58-49e0-8d5e-61816be89f74	https://ic.jimms.fi/product/9/4/421895-ig800gg.jpg
34fe477a-2ede-4e77-90e9-e7afeca9392c	https://ic.jimms.fi/product/8/6/431883-ig800gg.jpg
34fe477a-2ede-4e77-90e9-e7afeca9392c	https://ic.jimms.fi/product/8/3/431886-ig800gg.jpg
34fe477a-2ede-4e77-90e9-e7afeca9392c	https://ic.jimms.fi/product/8/4/431885-ig800gg.jpg
34fe477a-2ede-4e77-90e9-e7afeca9392c	https://ic.jimms.fi/product/8/7/431882-ig800gg.jpg
210e2ba9-98ff-4650-b833-5e3cf83bcfa6	https://ic.jimms.fi/product/6/8/352761-ig800gg.jpg
210e2ba9-98ff-4650-b833-5e3cf83bcfa6	https://ic.jimms.fi/product/6/7/352762-ig800gg.jpg
210e2ba9-98ff-4650-b833-5e3cf83bcfa6	https://ic.jimms.fi/product/6/6/352763-ig800gg.jpg
210e2ba9-98ff-4650-b833-5e3cf83bcfa6	https://ic.jimms.fi/product/6/5/352764-ig800gg.jpg
97269565-5557-4c9e-8131-ab60fb5a6d89	https://ic.jimms.fi/product/1/5/438214-ig800gg.jpg
97269565-5557-4c9e-8131-ab60fb5a6d89	https://ic.jimms.fi/product/1/6/438213-ig800gg.jpg
97269565-5557-4c9e-8131-ab60fb5a6d89	https://ic.jimms.fi/product/1/3/438216-ig800gg.jpg
97269565-5557-4c9e-8131-ab60fb5a6d89	https://ic.jimms.fi/product/1/0/438219-ig800gg.jpg
6fc1422b-9d7f-42db-abb7-98ebc9684a07	https://ic.jimms.fi/product/8/4/441485-ig800gg.jpg
6fc1422b-9d7f-42db-abb7-98ebc9684a07	https://ic.jimms.fi/product/8/2/441487-ig800gg.jpg
6fc1422b-9d7f-42db-abb7-98ebc9684a07	https://ic.jimms.fi/product/8/0/441489-ig800gg.jpg
6fc1422b-9d7f-42db-abb7-98ebc9684a07	https://ic.jimms.fi/product/9/9/441490-ig800gg.jpg
3d255fb2-da22-40b8-87d6-37c4e50dc40e	https://ic.jimms.fi/product/6/3/365266-ig800gg.jpg
3d255fb2-da22-40b8-87d6-37c4e50dc40e	https://ic.jimms.fi/product/6/2/365267-ig800gg.jpg
3d255fb2-da22-40b8-87d6-37c4e50dc40e	https://ic.jimms.fi/product/2/4/365925-ig800gg.jpg
3d255fb2-da22-40b8-87d6-37c4e50dc40e	https://ic.jimms.fi/product/2/0/365929-ig800gg.jpg
8e464bac-b941-4b69-82d3-637e6e3fdc4c	https://ic.jimms.fi/product/4/3/146846-ig800gg.jpg
8e464bac-b941-4b69-82d3-637e6e3fdc4c	https://ic.jimms.fi/product/4/1/146848-ig800gg.jpg
8e464bac-b941-4b69-82d3-637e6e3fdc4c	https://ic.jimms.fi/product/5/9/146850-ig800gg.jpg
8e464bac-b941-4b69-82d3-637e6e3fdc4c	https://ic.jimms.fi/product/4/2/146847-ig800gg.jpg
23ace5af-b7d3-494b-80e9-608e79991222	https://ic.jimms.fi/product/7/4/347175-ig800gg.jpg
b061b77a-c8a5-4703-b4bc-37948f4ff344	https://ic.jimms.fi/product/2/5/282124-ig800gg.jpg
b061b77a-c8a5-4703-b4bc-37948f4ff344	https://ic.jimms.fi/product/2/4/282125-ig800gg.jpg
b061b77a-c8a5-4703-b4bc-37948f4ff344	https://ic.jimms.fi/product/2/3/282126-ig800gg.jpg
b061b77a-c8a5-4703-b4bc-37948f4ff344	https://ic.jimms.fi/product/2/2/282127-ig800gg.jpg
881e7d4b-2a8a-4f2e-8c49-20f489c8ef81	https://ic.jimms.fi/product/9/0/365499-ig800gg.jpg
881e7d4b-2a8a-4f2e-8c49-20f489c8ef81	https://ic.jimms.fi/product/0/9/365500-ig800gg.jpg
881e7d4b-2a8a-4f2e-8c49-20f489c8ef81	https://ic.jimms.fi/product/0/8/365501-ig800gg.jpg
881e7d4b-2a8a-4f2e-8c49-20f489c8ef81	https://ic.jimms.fi/product/0/6/365503-ig800gg.jpg
44611cda-2b8d-4a7c-9f9e-9c1c523dc8d9	https://ic.jimms.fi/product/8/4/395185-ig800gg.jpg
1714ae45-33d8-4e2a-a2b7-8b6d1066de62	https://ic.jimms.fi/product/2/3/395126-ig800gg.jpg
200814b3-4da8-4c44-8c3f-68ac3069c3ab	https://ic.jimms.fi/product/8/8/366981-ig800gg.jpg
200814b3-4da8-4c44-8c3f-68ac3069c3ab	https://ic.jimms.fi/product/8/7/366982-ig800gg.jpg
200814b3-4da8-4c44-8c3f-68ac3069c3ab	https://ic.jimms.fi/product/8/6/366983-ig800gg.jpg
200814b3-4da8-4c44-8c3f-68ac3069c3ab	https://ic.jimms.fi/product/8/5/366984-ig800gg.jpg
200814b3-4da8-4c44-8c3f-68ac3069c3ab	https://ic.jimms.fi/product/8/4/366985-ig800gg.jpg
200814b3-4da8-4c44-8c3f-68ac3069c3ab	https://ic.jimms.fi/product/8/3/366986-ig800gg.jpg
ee9f2726-aea9-4078-80fc-0e7a99520769	https://ic.jimms.fi/product/7/4/349575-ig800gg.jpg
ee9f2726-aea9-4078-80fc-0e7a99520769	https://ic.jimms.fi/product/7/3/349576-ig800gg.jpg
ee9f2726-aea9-4078-80fc-0e7a99520769	https://ic.jimms.fi/product/7/2/349577-ig800gg.jpg
ee9f2726-aea9-4078-80fc-0e7a99520769	https://ic.jimms.fi/product/7/1/349578-ig800gg.jpg
ee9f2726-aea9-4078-80fc-0e7a99520769	https://ic.jimms.fi/product/8/9/349580-ig800gg.jpg
ee9f2726-aea9-4078-80fc-0e7a99520769	https://ic.jimms.fi/product/8/8/349581-ig800gg.jpg
9028f02a-d787-43a4-8feb-1096fd950b2f	https://ic.jimms.fi/product/7/1/355578-ig800gg.jpg
9028f02a-d787-43a4-8feb-1096fd950b2f	https://ic.jimms.fi/product/7/0/355579-ig800gg.jpg
9028f02a-d787-43a4-8feb-1096fd950b2f	https://ic.jimms.fi/product/8/9/355580-ig800gg.jpg
9028f02a-d787-43a4-8feb-1096fd950b2f	https://ic.jimms.fi/product/8/8/355581-ig800gg.jpg
9028f02a-d787-43a4-8feb-1096fd950b2f	https://ic.jimms.fi/product/8/7/355582-ig800gg.jpg
9028f02a-d787-43a4-8feb-1096fd950b2f	https://ic.jimms.fi/product/8/5/355584-ig800gg.jpg
1a322a50-9a14-4f21-bbd6-1a5900fc3cf7	https://ic.jimms.fi/product/2/4/185425-ig800gg.jpg
c9fb8e94-0fb4-440f-8922-c02675f25b2e	https://ic.jimms.fi/product/3/8/403331-ig800gg.jpg
dddd3cc8-f770-48aa-bdfd-df99646a1929	https://ic.jimms.fi/product/0/4/427905-ig800gg.jpg
e15db7fe-6bc4-44dd-8a82-12c26051d141	https://ic.jimms.fi/product/1/9/441610-ig800gg.jpg
e15db7fe-6bc4-44dd-8a82-12c26051d141	https://ic.jimms.fi/product/1/7/441612-ig800gg.jpg
e15db7fe-6bc4-44dd-8a82-12c26051d141	https://ic.jimms.fi/product/1/4/441615-ig800gg.jpg
432f5e05-daf0-4645-874c-58ce449b896b	https://ic.jimms.fi/product/5/2/444957-ig800gg.jpg
\.


--
-- Data for Name: statics; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.statics (stat_id, clicks, created_at, rating) FROM stdin;
9bab2f25-7e14-45b8-8ab0-0526ee37cb9c	7	2023-05-19 00:00:00	5
50296d41-04f7-490a-8d8d-6e3a82d83b66	4	2023-05-19 00:00:00	4
539b2e25-cfc3-4734-8261-bda33a794787	8	2023-05-18 15:45:43.499678	0
ee1c206a-d38b-43f9-bbcb-c0ee6fbae2f3	10	2023-05-18 00:00:00	4
29fb4792-9436-42b4-805b-1032c42bff2a	20	2023-05-19 00:00:00	5
f9036a28-d7af-4783-95c6-cdc2646b98f5	3	2023-05-18 15:44:54.550266	0
28d44670-1422-4147-a9fe-13918e9effb3	0	2023-05-19 00:00:00	4
8463ebbb-b9b3-4fd0-8989-ce6b5ae14a70	0	2023-05-19 00:00:00	4
a1571718-f497-4fe3-bd8a-43017b64aae8	0	2023-05-19 00:00:00	4
f0c36f92-23ec-4eef-adaf-fdd9bf89add7	9	2023-05-18 15:45:49.293427	0
10023274-047d-4ff5-a04f-76fc51db31f4	0	2023-05-20 00:00:00	5
45faed97-5527-4e73-bb87-2ae53cb4dfb5	0	2023-05-20 00:00:00	5
e0b9eeb6-b939-4e50-950c-ae8c550655bd	0	2023-05-20 00:00:00	5
c4b2cf23-1abb-4d7b-993d-a8f579fdc45f	0	2023-05-20 00:00:00	4
2c52992f-20be-47d6-ac15-ec5d63e1175d	0	2023-05-20 00:00:00	4
97d85ebe-9893-4255-94b3-305a26ce76ea	0	2023-05-20 00:00:00	3
7d4239a1-f930-4b22-87fc-247a68597643	0	2023-05-20 00:00:00	4
26182c5b-dcd6-42ef-a8ce-e91c0292c783	10	2023-05-18 00:00:00	0
7b1f5c0a-60bf-464c-a97d-a2b918a3c434	0	2023-05-28 00:00:00	5
2e480d5d-335d-4da2-b54b-ee52ec0b5bcc	1	2023-05-22 00:00:00	4
4f5dff77-8a93-43a7-a6aa-76cb29f2bec3	1	2023-05-28 00:00:00	5
bcd80285-db2b-49c8-8420-351ae1a23e46	0	2023-05-26 00:00:00	4
785a5a99-30eb-4814-8e10-7ba693cfa3c8	16	2023-05-18 00:00:00	0
476acf91-41cb-4313-84da-0371fa652fcf	4	2023-05-20 00:00:00	2
12cd6ec7-7c68-461f-86ac-b9be229a4593	0	2023-05-29 00:00:00	4
ec52b28a-f75a-44c1-880d-d440f1564ed9	40	2023-05-19 00:00:00	3
e9de3927-1d8b-4ce6-bf8c-5fe2086edfa4	50	2023-05-20 00:00:00	3
49d9f33c-8e66-4bff-979d-04fb1ea34713	11	2023-05-18 15:45:38.302102	0
6da1b3f7-499f-4892-8db4-7592f57c9bb6	7	2023-05-18 15:45:47.122319	0
2b85bb9e-9743-4a87-b024-d889326c602c	39	2023-05-20 00:00:00	5
d14af3bb-63aa-467d-a071-cf87fd40f0dc	2	2023-05-29 00:00:00	4
\.


--
-- Name: cart cart_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_pkey PRIMARY KEY (cart_id);


--
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (category_id);


--
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: statics statics_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.statics
    ADD CONSTRAINT statics_pkey PRIMARY KEY (stat_id);


--
-- Name: customer uk_irnrrncatp2fvw52vp45j7rlw; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT uk_irnrrncatp2fvw52vp45j7rlw UNIQUE (username);


--
-- Name: category uk_lnmf77qvjnr2lmyxrrydom9hd; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT uk_lnmf77qvjnr2lmyxrrydom9hd UNIQUE (title);


--
-- Name: product_images fki8jnqq05sk5nkma3pfp3ylqrt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_images
    ADD CONSTRAINT fki8jnqq05sk5nkma3pfp3ylqrt FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- Name: product fkla0h79g6773422w81qhws0ufy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fkla0h79g6773422w81qhws0ufy FOREIGN KEY (statics_stat_id) REFERENCES public.statics(stat_id);


--
-- Name: product fkle1pobdrc8a2uw97gukfmvan4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fkle1pobdrc8a2uw97gukfmvan4 FOREIGN KEY (category_category_id) REFERENCES public.category(category_id);


--
-- PostgreSQL database dump complete
--

