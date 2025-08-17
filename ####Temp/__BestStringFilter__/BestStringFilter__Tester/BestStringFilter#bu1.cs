using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace BestStringFilter__Tester
{
    public static class BestStringFilter
    {
        private static void prPrintOut(string msg)
        {
            Console.WriteLine(msg);
        }

        public const string CbtResult = "Result";
        public static Action<string, object> Callback;

        private const char _pyp = '%';

        public const char PkL = 'l';
        public const char PkC = 'c';
        public const char PkR = 'r';

        public static (string, char) GetCriticalState(string ips)
        {
            (string rst, char rp) = (string.Empty, char.MinValue);

            if ((ips == null) || (ips.Length == 0)) return (rst, rp);


            int len = ips.Length;
            int fi, ei, pi, qi;
            char fc, ec;

            if (len > 2)
            {
                fi = 0; ei = len - 1;
                fc = ips[fi]; ec = ips[ei];

                if ((fc == _pyp) && (ec == _pyp))
                {
                    pi = fi + 1; qi = ei - pi;
                    rst = ips.Substring(pi, qi);
                    rp = PkC;
                }
                else if (fc == _pyp)
                {
                    pi = fi + 1; qi = ei;
                    rst = ips.Substring(pi, qi);
                    rp = PkR;
                }
                else if (ec == _pyp)
                {
                    pi = fi; qi = ei - pi;
                    rst = ips.Substring(pi, qi);
                    rp = PkL;
                }
                else
                {
                    rst = ips;
                    rp = PkC;
                }
            }
            else if (len == 2)
            {
                fi = 0; ei = 1;
                fc = ips[fi]; ec = ips[ei];

                if (fc == _pyp)
                {
                    pi = fi + 1; qi = ei;
                    rst = ips.Substring(pi, qi);
                    rp = PkR;
                }
                else if (ec == _pyp)
                {
                    pi = fi; qi = ei - pi;
                    rst = ips.Substring(pi, qi);
                    rp = PkL;
                }
                else
                {
                    rst = ips;
                    rp = PkC;
                }
            }
            else if (len == 1)
            {
                fi = 0;
                fc = ips[fi];

                if (fc != _pyp)
                {
                    rst = ips;
                    rp = PkC;
                }
            }

            //prPrintOut($"{ips} > {rst}, {rp}");
            return (rst, rp);
        }

        public static bool CheckUpInputText(string txt, string ips)
        {
            if ((txt == null) || (txt.Length == 0)) return false;

            (string cst, char cx) = GetCriticalState(ips);
            if (string.IsNullOrWhiteSpace(cst)) return false;

            if (cx == PkL)
            {
                if (txt.StartsWith(cst))
                {
                    return true;
                }
            }
            else if (cx == PkR)
            {
                if (txt.EndsWith(cst))
                {
                    return true;
                }
            }
            else if (cx == PkC)
            {
                if (txt.Contains(cst))
                {
                    return true;
                }
            }


            return false;
        }

        public static void WaveFullScan(string txt, string fps)
        {
            string[] wds = fps.Split(new char[] { ';' }, StringSplitOptions.None);
            if ((wds != null) && (wds.Length > 0))
            {

            }
        }

    }
}
