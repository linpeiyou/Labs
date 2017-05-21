# NotePad
## 1.基本功能实现
 ### 时间戳显示
源工程往数据库中"created"与"modified"两列插入的为时间戳，我 在NotepadProvider中查找对应代码，通过格式转换，在时间戳插入之前将其转换为("yyyy-MM-dd HH:mm:ss aa")格式。

** 代码如下：**
```
long now = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");
        String nowTime = sdf.format(new Date(now));

```
接着修改noteslist.xml，添加时间戳显示对应的textview，
然后通过更改Noteslist中的SimpleCursorAdapter 的from 与 to 参数，将时间戳显示在noteslist.xml下的textview中;

### 模糊搜索功能
通过Noteslist右上角的menu点击“查找”，弹出一个ALertdialog输入要搜索的笔记标题，然后通过查询结果，重新设置适配器以显示新的结果。

** 核心代码如下 **
```
String[] search = {"_id", NotePad.Notes.COLUMN_NAME_TITLE, NotePad.Notes
                               .COLUMN_NAME_CREATE_DATE};
                       String selection = NotePad.Notes.COLUMN_NAME_TITLE + " like?";
                       String[] a = {input_word + "%"};
                       if (a[0].equals("%"))
                           Toast.makeText(NotesList.this, "清空搜索列表", Toast.LENGTH_SHORT).show();
                       Cursor cursors = managedQuery(getIntent().getData(), search, selection,
                               a, NotePad.Notes.DEFAULT_SORT_ORDER);
                       cursors.moveToFirst();
                       String[] data = {NotePad.Notes.COLUMN_NAME_TITLE, NotePad.Notes
                               .COLUMN_NAME_CREATE_DATE};
                       final int[] viewID = {android.R.id.text1, R.id.tv_time};
                       SimpleCursorAdapter adapters = new SimpleCursorAdapter(NotesList.this,
                               R.layout.noteslist_item,
                               cursors,                           
                               data, viewID);
                       setListAdapter(adapters);
```

** 效果演示 **

** 搜索前 **

** 搜索后 **

** 搜索结果清空 **

## 2.拓展功能实现
### UI美化

** 效果演示 **

### 背景换色

**  效果演示 **
