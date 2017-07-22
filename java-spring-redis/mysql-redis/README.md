# 注意

运行main方法，首先从redis中获取数据，若没有，查询数据库后写入redis.首次运行时，肯定是从mysql取数据，再次运行就会从redis取数据
