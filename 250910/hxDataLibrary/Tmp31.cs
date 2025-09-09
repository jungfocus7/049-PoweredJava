// Decompiled with JetBrains decompiler
// Type: hxDataLibrary.DataExtensions.CollectionExtension
// Assembly: hxDataLibrary, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null
// MVID: 47BA3D60-96AB-4594-A864-8ED8D85605C9
// Assembly location: D:\049-PoweredJava\250910\hxDataLibrary\##Debug\hxDataLibrary.exe

#nullable disable
namespace hxDataLibrary.DataExtensions
{
  public static class CollectionExtension
  {
  }
}







// Decompiled with JetBrains decompiler
// Type: hxDataLibrary.DataExtensions.DataRowExtension
// Assembly: hxDataLibrary, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null
// MVID: 47BA3D60-96AB-4594-A864-8ED8D85605C9
// Assembly location: D:\049-PoweredJava\250910\hxDataLibrary\##Debug\hxDataLibrary.exe

using System;
using System.Data;

#nullable disable
namespace hxDataLibrary.DataExtensions
{
  public static class DataRowExtension
  {
    public static bool CheckColumn(this DataRow drow, string cnm)
    {
      return drow != null && drow.Table.CheckColumn(cnm);
    }

    public static object GetValue(this DataRow drow, string cnm, object dv = null)
    {
      return drow.CheckColumn(cnm) ? drow[cnm] : dv;
    }

    public static string GetString(this DataRow drow, string cnm, string dv = null)
    {
      object obj = drow.GetValue(cnm);
      return obj != null ? obj.ToString() : dv;
    }

    public static int GetInt32(this DataRow drow, string cnm, int dv = 0)
    {
      object obj = drow.GetValue(cnm);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToInt32(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static long GetInt64(this DataRow drow, string cnm, long dv = 0)
    {
      object obj = drow.GetValue(cnm);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToInt64(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static float GetSingle(this DataRow drow, string cnm, float dv = 0.0f)
    {
      object obj = drow.GetValue(cnm);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToSingle(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static double GetDouble(this DataRow drow, string cnm, double dv = 0.0)
    {
      object obj = drow.GetValue(cnm);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToDouble(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static Decimal GetDecimal(this DataRow drow, string cnm, Decimal dv = 0M)
    {
      object obj = drow.GetValue(cnm);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToDecimal(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static uint GetUInt32(this DataRow drow, string cnm, uint dv = 0)
    {
      object obj = drow.GetValue(cnm);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToUInt32(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static ulong GetUInt64(this DataRow drow, string cnm, ulong dv = 0)
    {
      object obj = drow.GetValue(cnm);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToUInt64(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static short GetInt16(this DataRow drow, string cnm, short dv = 0)
    {
      object obj = drow.GetValue(cnm);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToInt16(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static ushort GetUInt16(this DataRow drow, string cnm, ushort dv = 0)
    {
      object obj = drow.GetValue(cnm);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToUInt16(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static sbyte GetSByte(this DataRow drow, string cnm, sbyte dv = 0)
    {
      object obj = drow.GetValue(cnm);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToSByte(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static byte GetByte(this DataRow drow, string cnm, byte dv = 0)
    {
      object obj = drow.GetValue(cnm);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToByte(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static char GetChar(this DataRow drow, string cnm, char dv = '\0')
    {
      object obj = drow.GetValue(cnm);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToChar(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static DateTime GetDateTime(this DataRow drow, string cnm, DateTime dv = default (DateTime))
    {
      object obj = drow.GetValue(cnm);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToDateTime(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static TimeSpan GetTimeSpan(this DataRow drow, string cnm, TimeSpan dv = default (TimeSpan))
    {
      object timeSpan = drow.GetValue(cnm);
      if (timeSpan == null)
        return dv;
      try
      {
        return (TimeSpan) timeSpan;
      }
      catch
      {
        return dv;
      }
    }

    public static Guid GetGuid(this DataRow drow, string cnm, Guid dv = default (Guid))
    {
      object guid = drow.GetValue(cnm);
      if (guid == null)
        return dv;
      try
      {
        return (Guid) guid;
      }
      catch
      {
        return dv;
      }
    }
  }
}



// Decompiled with JetBrains decompiler
// Type: hxDataLibrary.DataExtensions.DataTableExtension
// Assembly: hxDataLibrary, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null
// MVID: 47BA3D60-96AB-4594-A864-8ED8D85605C9
// Assembly location: D:\049-PoweredJava\250910\hxDataLibrary\##Debug\hxDataLibrary.exe

using System;
using System.Data;

#nullable disable
namespace hxDataLibrary.DataExtensions
{
  public static class DataTableExtension
  {
    public static bool IsEmpty(this DataTable table) => table == null || table.Rows.Count == 0;

    public static bool NotEmpty(this DataTable table) => table != null && table.Rows.Count > 0;

    public static bool CheckColumn(this DataTable table, string cnm)
    {
      DataColumnCollection columns = table?.Columns;
      return columns != null && columns.Count > 0 && columns.Contains(cnm);
    }

    public static object GetValue(this DataTable table, string cnm, int ri, object dv = null)
    {
      if (table.IsEmpty() || string.IsNullOrWhiteSpace(cnm) || !table.Columns.Contains(cnm))
        return dv;
      DataRowCollection rows = table.Rows;
      if (ri < 0 || ri >= rows.Count)
        return dv;
      object obj = rows[ri][cnm];
      return !Convert.IsDBNull(obj) ? obj : dv;
    }

    public static string GetString(this DataTable table, string cnm, int ri, string dv = null)
    {
      object obj = table.GetValue(cnm, ri);
      return obj != null ? obj.ToString() : dv;
    }

    public static int GetInt32(this DataTable table, string cnm, int ri, int dv = 0)
    {
      object obj = table.GetValue(cnm, ri);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToInt32(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static long GetInt64(this DataTable table, string cnm, int ri, long dv = 0)
    {
      object obj = table.GetValue(cnm, ri);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToInt64(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static float GetSingle(this DataTable table, string cnm, int ri, float dv = 0.0f)
    {
      object obj = table.GetValue(cnm, ri);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToSingle(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static double GetDouble(this DataTable table, string cnm, int ri, double dv = 0.0)
    {
      object obj = table.GetValue(cnm, ri);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToDouble(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static Decimal GetDecimal(this DataTable table, string cnm, int ri, Decimal dv = 0M)
    {
      object obj = table.GetValue(cnm, ri);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToDecimal(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static uint GetUInt32(this DataTable table, string cnm, int ri, uint dv = 0)
    {
      object obj = table.GetValue(cnm, ri);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToUInt32(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static ulong GetUInt64(this DataTable table, string cnm, int ri, ulong dv = 0)
    {
      object obj = table.GetValue(cnm, ri);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToUInt64(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static short GetInt16(this DataTable table, string cnm, int ri, short dv = 0)
    {
      object obj = table.GetValue(cnm, ri);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToInt16(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static ushort GetUInt16(this DataTable table, string cnm, int ri, ushort dv = 0)
    {
      object obj = table.GetValue(cnm, ri);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToUInt16(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static sbyte GetSByte(this DataTable table, string cnm, int ri, sbyte dv = 0)
    {
      object obj = table.GetValue(cnm, ri);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToSByte(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static byte GetByte(this DataTable table, string cnm, int ri, byte dv = 0)
    {
      object obj = table.GetValue(cnm, ri);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToByte(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static char GetChar(this DataTable table, string cnm, int ri, char dv = '\0')
    {
      object obj = table.GetValue(cnm, ri);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToChar(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static DateTime GetDateTime(this DataTable table, string cnm, int ri, DateTime dv = default (DateTime))
    {
      object obj = table.GetValue(cnm, ri);
      if (obj == null)
        return dv;
      try
      {
        return Convert.ToDateTime(obj);
      }
      catch
      {
        return dv;
      }
    }

    public static TimeSpan GetTimeSpan(this DataTable table, string cnm, int ri, TimeSpan dv = default (TimeSpan))
    {
      object timeSpan = table.GetValue(cnm, ri);
      if (timeSpan == null)
        return dv;
      try
      {
        return (TimeSpan) timeSpan;
      }
      catch
      {
        return dv;
      }
    }

    public static Guid GetGuid(this DataTable table, string cnm, int ri, Guid dv = default (Guid))
    {
      object guid = table.GetValue(cnm, ri);
      if (guid == null)
        return dv;
      try
      {
        return (Guid) guid;
      }
      catch
      {
        return dv;
      }
    }

    public static T GetValue<T>(this DataTable table, string cnm, int ri, T dv = default (T)) where T : struct
    {
      object obj = table.GetValue(cnm, ri);
      if (obj == null)
        return dv;
      try
      {
        return (T) obj;
      }
      catch
      {
        return dv;
      }
    }
  }
}











// Decompiled with JetBrains decompiler
// Type: hxDataLibrary.TesterProgram
// Assembly: hxDataLibrary, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null
// MVID: 47BA3D60-96AB-4594-A864-8ED8D85605C9
// Assembly location: D:\049-PoweredJava\250910\hxDataLibrary\##Debug\hxDataLibrary.exe

using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Reflection;

#nullable disable
namespace hxDataLibrary
{
  public static class TesterProgram
  {
    private static readonly DataTable _table = new DataTable("RESULT");

    public static void Main(string[] args)
    {
      TesterProgram._table.Reset();
      TesterProgram._table.Columns.Add("COL01", typeof (object));
      TesterProgram._table.Columns.Add("COL02", typeof (object));
      TesterProgram._table.Columns.Add("COL03", typeof (object));
      TesterProgram._table.Columns.Add("COL04", typeof (bool));
      TesterProgram._table.Columns.Add("COL05", typeof (short));
      TesterProgram._table.Rows.Add((object) "RV01", (object) "RV02", (object) "RV03");
      TesterProgram._table.Rows.Add((object) "RV01", (object) "RV02", (object) "RV03");
      TesterProgram._table.Rows.Add((object) "RV01", (object) "RV02", (object) new List<string>());
      TesterProgram._table.Rows.Add((object) 333, (object) "RV02", (object) new List<string>());
      TesterProgram._table.Rows.Add((object) 333, (object) "RV02", (object) new List<string>(), (object) true, (object) -333);
      TesterProgram.Tester31();
    }

    private static void Tester31()
    {
      ((IEnumerable<Assembly>) AppDomain.CurrentDomain.GetAssemblies()).SelectMany<Assembly, Type>((System.Func<Assembly, IEnumerable<Type>>) (assembly =>
      {
        try
        {
          return (IEnumerable<Type>) assembly.GetTypes();
        }
        catch (ReflectionTypeLoadException ex)
        {
          return ((IEnumerable<Type>) ex.Types).Where<Type>((System.Func<Type, bool>) (t => t != (Type) null));
        }
      })).ToList<Type>();
      33.GetValue<string>();
      DataTable dataTable = new DataTable("ComprehensiveTable");
      dataTable.Columns.Add("SbyteCol", typeof (sbyte));
      dataTable.Columns.Add("ByteCol", typeof (byte));
      dataTable.Columns.Add("ShortCol", typeof (short));
      dataTable.Columns.Add("UshortCol", typeof (ushort));
      dataTable.Columns.Add("IntCol", typeof (int));
      dataTable.Columns.Add("UintCol", typeof (uint));
      dataTable.Columns.Add("LongCol", typeof (long));
      dataTable.Columns.Add("UlongCol", typeof (ulong));
      dataTable.Columns.Add("FloatCol", typeof (float));
      dataTable.Columns.Add("DoubleCol", typeof (double));
      dataTable.Columns.Add("DecimalCol", typeof (Decimal));
      dataTable.Columns.Add("CharCol", typeof (char));
      dataTable.Columns.Add("StringCol", typeof (string));
      dataTable.Columns.Add("BoolCol", typeof (bool));
      dataTable.Columns.Add("DateTimeCol", typeof (DateTime));
      dataTable.Columns.Add("TimeSpanCol", typeof (TimeSpan));
      dataTable.Columns.Add("GuidCol", typeof (Guid));
      dataTable.Columns.Add("ObjectCol", typeof (object));
      dataTable.Columns.Add("ByteArrayCol", typeof (byte[]));
      DataRow row = dataTable.NewRow();
      row["SbyteCol"] = (object) sbyte.MinValue;
      row["ByteCol"] = (object) byte.MaxValue;
      row["ShortCol"] = (object) short.MinValue;
      row["UshortCol"] = (object) ushort.MaxValue;
      row["IntCol"] = (object) int.MaxValue;
      row["UintCol"] = (object) uint.MaxValue;
      row["LongCol"] = (object) long.MaxValue;
      row["UlongCol"] = (object) ulong.MaxValue;
      row["FloatCol"] = (object) 123.45f;
      row["DoubleCol"] = (object) 123.456789;
      row["DecimalCol"] = (object) 12345.6789M;
      row["CharCol"] = (object) 'A';
      row["StringCol"] = (object) "C# 데이터 타입 테스트";
      row["BoolCol"] = (object) true;
      row["DateTimeCol"] = (object) DateTime.Now;
      row["TimeSpanCol"] = (object) TimeSpan.FromHours(2.0);
      row["GuidCol"] = (object) Guid.NewGuid();
      row["ObjectCol"] = (object) new string[2]
      {
        "object",
        "array"
      };
      row["ByteArrayCol"] = (object) new byte[5]
      {
        (byte) 1,
        (byte) 2,
        (byte) 3,
        (byte) 4,
        (byte) 5
      };
      dataTable.Rows.Add(row);
      Console.WriteLine("테이블명: " + dataTable.TableName);
      Console.WriteLine(string.Format("총 컬럼 수: {0}", (object) dataTable.Columns.Count));
      Console.WriteLine();
      Console.WriteLine("--- 컬럼 정보 ---");
      foreach (DataColumn column in (InternalDataCollectionBase) dataTable.Columns)
        Console.WriteLine("컬럼명: " + column.ColumnName + ", 데이터 타입: " + column.DataType.Name);
      Console.WriteLine("\n--- 데이터 (첫 번째 행) ---");
      foreach (DataColumn column in (InternalDataCollectionBase) dataTable.Columns)
      {
        object obj = row[column.ColumnName];
        string str = "null";
        if (obj is byte[] numArray)
          str = BitConverter.ToString(numArray);
        else if (obj != null)
          str = obj.ToString();
        Console.WriteLine(column.ColumnName + ": " + str);
      }
    }

    public static T GetValue<T>(this object vo, T dv = null)
    {
      T obj = default (T);
      switch (Type.GetTypeCode(typeof (T)))
      {
        case TypeCode.Boolean:
          try
          {
            obj = (T) (System.ValueType) Convert.ToBoolean(vo);
            break;
          }
          catch
          {
            break;
          }
        case TypeCode.Char:
          try
          {
            obj = (T) (System.ValueType) Convert.ToChar(vo);
            break;
          }
          catch
          {
            break;
          }
        case TypeCode.SByte:
          try
          {
            obj = (T) (System.ValueType) Convert.ToSByte(vo);
            break;
          }
          catch
          {
            break;
          }
        case TypeCode.Byte:
          try
          {
            obj = (T) (System.ValueType) Convert.ToByte(vo);
            break;
          }
          catch
          {
            break;
          }
        case TypeCode.Int16:
          try
          {
            obj = (T) (System.ValueType) Convert.ToInt16(vo);
            break;
          }
          catch
          {
            break;
          }
        case TypeCode.UInt16:
          try
          {
            obj = (T) (System.ValueType) Convert.ToUInt16(vo);
            break;
          }
          catch
          {
            break;
          }
        case TypeCode.Int32:
          try
          {
            obj = (T) (System.ValueType) Convert.ToInt32(vo);
            break;
          }
          catch
          {
            break;
          }
        case TypeCode.UInt32:
          try
          {
            obj = (T) (System.ValueType) Convert.ToUInt32(vo);
            break;
          }
          catch
          {
            break;
          }
        case TypeCode.Int64:
          try
          {
            obj = (T) (System.ValueType) Convert.ToInt64(vo);
            break;
          }
          catch
          {
            break;
          }
        case TypeCode.UInt64:
          try
          {
            obj = (T) (System.ValueType) Convert.ToUInt64(vo);
            break;
          }
          catch
          {
            break;
          }
        case TypeCode.Single:
          try
          {
            obj = (T) (System.ValueType) Convert.ToSingle(vo);
            break;
          }
          catch
          {
            break;
          }
        case TypeCode.Double:
          try
          {
            obj = (T) (System.ValueType) Convert.ToDouble(vo);
            break;
          }
          catch
          {
            break;
          }
        case TypeCode.Decimal:
          try
          {
            obj = (T) (System.ValueType) Convert.ToDecimal(vo);
            break;
          }
          catch
          {
            break;
          }
        case TypeCode.DateTime:
          try
          {
            obj = (T) (System.ValueType) Convert.ToDateTime(vo);
            break;
          }
          catch
          {
            break;
          }
        case TypeCode.String:
          try
          {
            obj = (T) Convert.ToString(vo);
            break;
          }
          catch
          {
            break;
          }
      }
      return obj;
    }
  }
}
