package uz.gita.fooddeliveryapp_bek.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.gita.fooddeliveryapp_bek.data.source.local.dao.ProductDao
import uz.gita.fooddeliveryapp_bek.data.source.local.entity.ProductEntity

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getProductsDao(): ProductDao

}