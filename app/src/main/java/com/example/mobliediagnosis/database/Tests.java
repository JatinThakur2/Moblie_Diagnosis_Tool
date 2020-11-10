package com.example.mobliediagnosis.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tests")
public class Tests {

    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    @ColumnInfo(name = "time")
    private String time;

    @NonNull
    @ColumnInfo(name = "type")
    private String type;

    @NonNull
    @ColumnInfo(name = "extras")
    private String extra;

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getTime() {
        return time;
    }

    public void setTime(@NonNull String time) {
        this.time = time;
    }

    @NonNull
    public String getType() {
        return type;
    }

    public void setType(@NonNull String type) {
        this.type = type;
    }

    @NonNull
    public String getExtra() {
        return extra;
    }

    public void setExtra(@NonNull String extra) {
        this.extra = extra;
    }

    public Tests(@NonNull String id, @NonNull String time, @NonNull String type, @NonNull String extra) {
        this.id = id;
        this.time = time;
        this.type = type;
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
                ", extra='" + extra + '\'';
    }
}
