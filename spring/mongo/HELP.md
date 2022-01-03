创建库
use cydeer;

创建用户
db.createUser({user:"cydeer",pwd:"cydeer",roles:[{role:"readWrite",db:"cydeer"}]});

use cydeer;

show collections;

db.{collection}.find();