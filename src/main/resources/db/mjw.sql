-- ----------------------------
MYSQL
-- ----------------------------

DROP DATABASE IF EXISTS mjw_device;
CREATE DATABASE mjw_device;
CREATE TABLE mjw_device.`user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO mjw_device.`user` VALUES ('1', 'device');

-- ----------------------------

-- ----------------------------

DROP DATABASE IF EXISTS mjw_order;
CREATE DATABASE mjw_order;
CREATE TABLE mjw_order.`user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO mjw_order.`user` VALUES ('1', 'order');

-- ----------------------------

-- ----------------------------

DROP DATABASE IF EXISTS mjw_user;
CREATE DATABASE mjw_user;
CREATE TABLE mjw_user.`user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO mjw_user.`user` VALUES ('1', 'user');

-- ----------------------------

-- ----------------------------

DROP DATABASE IF EXISTS mjw_wallet;
CREATE DATABASE mjw_wallet;
CREATE TABLE mjw_wallet.`user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO mjw_wallet.`user` VALUES ('1', 'wallet');

-- ----------------------------

-- ----------------------------
