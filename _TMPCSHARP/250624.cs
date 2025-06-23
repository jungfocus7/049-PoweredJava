using Microsoft.VisualBasic.FileIO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;


namespace ConsoleApp1
{
    public sealed class FileInfo
    {
        public int Num;
        public string Path;

        public FileInfo(int num, string path)
        {
            Num = 0;
            Path = path;
        }

        public override string ToString()
        {
            return Path;
        }
    }

    public static class TesterProgram
    {
        public static void Main(string[] args)
        {
            FileInfo[] users =
            {
new FileInfo(1, @"src\main\java\org\apache\commons\text\diff\KeepCommand.java"),
new FileInfo(2, @"src\main\java\org\apache\commons\text\diff\ReplacementsFinder.java"),
new FileInfo(3, @"src\main\java\org\apache\commons\text\diff\DeleteCommand.java"),
new FileInfo(4, @"src\main\java\org\apache\commons\text\diff\EditCommand.java"),
new FileInfo(5, @"src\main\java\org\apache\commons\text\diff\package-info.java"),
new FileInfo(6, @"src\main\java\org\apache\commons\text\diff\CommandVisitor.java"),
new FileInfo(7, @"src\main\java\org\apache\commons\text\diff\StringsComparator.java"),
new FileInfo(8, @"src\main\java\org\apache\commons\text\diff\EditScript.java"),
new FileInfo(9, @"src\main\java\org\apache\commons\text\diff\ReplacementsHandler.java"),
new FileInfo(10, @"src\main\java\org\apache\commons\text\diff\InsertCommand.java"),
            };

            Array.Sort(users,
                delegate (FileInfo tx, FileInfo ty)
                {
                    int rn = string.Compare(tx.Path, ty.Path);
                    if (rn < 0) rn = 1;
                    else if (rn > 0) rn = -1;
                    return rn;
                });
        }





        //public static void Main(string[] args)
        //{
        //    //string[] names = { "최서방", "정희범", "박종명", "박종명", "임헌진", "이중호", "박종명" };

        //    //HashSet<string> hss = new HashSet<string>(names);
        //    ////hss.Add("박종명");
        //    ////hss.Add("임헌진");
        //    ////hss.Add("박종명");
        //    ////hss.Add("박종명");
        //    ////hss.Add("박종명");
        //    //string[] rarr = hss.ToArray();
        //    //Array.Sort(rarr);

        //    ////System.Collections.Generic.
        //    ///

        //    //string l_str = "안녕하세요. \"\"\"임헌진님.\"";
        //    //l_str = Regex.Replace(l_str, "\"",
        //    //    delegate (Match p_m)
        //    //    {
        //    //        return "\"\"";
        //    //    });
        //    //l_str = $"\"{l_str}\"";

        //    //Regex l_reg = new Regex("", RegexOptions.IgnoreCase);
        //    //l_reg.Replace("", "", 1);

        //    //TextFieldParser l_tfp = new TextFieldParser("");

        //}
    }
}
