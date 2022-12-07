package com.example.receipt.recycle
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.time.LocalDate


@Entity(tableName = "mylist")
class MyList(@PrimaryKey var id: Long?,
          @ColumnInfo(name = "icon") var item: Int,
          @ColumnInfo(name = "name") var name: String,
          @ColumnInfo(name = "categories") var category: String,
          @ColumnInfo(name = "dates") var dates: String, //유통기한
          @ColumnInfo(name = "expridate") var expridate: String, //소비기한
          @ColumnInfo(name = "startday") var startday: String,
          @ColumnInfo(name = "storage") var storage: String, //보관 상태
          @ColumnInfo(name = "storage_info") var storage_info: String, // 보관 방법
          @ColumnInfo(name = "index") var index: Int,







             ): Serializable {
        constructor(): this(null,0,"","","","","","","",0)
}
