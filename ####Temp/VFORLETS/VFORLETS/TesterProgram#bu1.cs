using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VFORLETS
{
    public static class TesterProgram
    {
        public static void Main(string[] args)
        {
            List<string> lst = Enumerable.Range(1, 101)
                //.Select(tx => tx.ToString().PadLeft(3, '0'))
                .Select(tx => "100")
                .ToList(); ;

            //string rst = MakeWhereAndInCond3(lst, "WORD");
            string rst = MakeWhereAndInCond3(lst, "EMPLOYEE_ID");
        }


        private static string MakeWhereAndInCond3(this List<string> lst, string wc)
        {
            if ((lst == null) || (lst.Count == 0)) return null;

            string tc1 = $"  {wc} IN (";

            StringBuilder tsb = new StringBuilder();
            tsb.Append(tc1);

            bool bf = true;
            for (int l = lst.Count, i = 0; i < l; i++)
            {
                if ((i > 0) && ((i % 10) == 0))
                {
                    string tx = tsb.ToString();
                    tsb.AppendLine(") OR");
                    tsb.Append(tc1);
                    bf = true;
                }

                string vs = lst[i];
                if (bf)
                {
                    tsb.Append($"'{vs}'");
                    bf = false;
                }
                else
                {
                    tsb.Append($",'{vs}'");
                }

                if (i == (l - 1))
                {
                    tsb.Append(')');
                }
            }

            if (tsb.Length > 0)
            {
                string rst = tsb.ToString();
                tsb.Clear();
                tsb.AppendLine("AND (");
                tsb.AppendLine(rst);
                tsb.Append(')');
                rst = tsb.ToString();

                return rst;
            }   
            else
                return null;
        }

    }
}
