package com.example.animelist.database

//@Database(entities = [Anime::class], version = 1)
//abstract class AnimeDataBase: RoomDatabase() {
//    abstract fun animeDao(): AnimeDAO
//
//    companion object {
//        @Volatile
//        private var INSTANCE: AnimeDataBase? = null
//
//        fun getDatabase(context:Context): AnimeDataBase {
//            val tempInstance = INSTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//            synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AnimeDataBase::class.java,
//                    "AnimeDataBase"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }
//}
