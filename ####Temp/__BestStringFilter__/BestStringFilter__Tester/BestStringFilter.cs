using System;


namespace BestStringFilter__Tester
{
    public static class BestStringFilter
    {
        private static void prPrintOut(string msg)
        {
            Console.WriteLine(msg);
        }

        public static Action<string> Callback;
        private const char _pyp = '%';
        private const char _pkl = 'l';
        private const char _pkc = 'c';
        private const char _pkr = 'r';

        private static (string, char) prGetCriticalState(string ips)
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
                    rp = _pkc;
                }
                else if (fc == _pyp)
                {
                    pi = fi + 1; qi = ei;
                    rst = ips.Substring(pi, qi);
                    rp = _pkr;
                }
                else if (ec == _pyp)
                {
                    pi = fi; qi = ei - pi;
                    rst = ips.Substring(pi, qi);
                    rp = _pkl;
                }
                else
                {
                    rst = ips;
                    rp = _pkc;
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
                    rp = _pkr;
                }
                else if (ec == _pyp)
                {
                    pi = fi; qi = ei - pi;
                    rst = ips.Substring(pi, qi);
                    rp = _pkl;
                }
                else
                {
                    rst = ips;
                    rp = _pkc;
                }
            }
            else if (len == 1)
            {
                fi = 0;
                fc = ips[fi];

                if (fc != _pyp)
                {
                    rst = ips;
                    rp = _pkc;
                }
            }

            //prPrintOut($"{ips} > {rst}, {rp}");
            return (rst, rp);
        }

        public static bool CheckUpInputText(string txt, string ips)
        {
            if ((txt == null) || (txt.Length == 0)) return false;

            (string cst, char cx) = prGetCriticalState(ips.ToUpper());
            if (string.IsNullOrWhiteSpace(cst)) return false;

            if (cx == _pkl)
            {
                if (txt.StartsWith(cst))
                {
                    return true;
                }
            }
            else if (cx == _pkr)
            {
                if (txt.EndsWith(cst))
                {
                    return true;
                }
            }
            else if (cx == _pkc)
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
            if ((wds == null) || (wds.Length == 0)) return;

            foreach (string wd in wds)
            {
                bool br = CheckUpInputText(txt, wd);
                if (br)
                {
                    Callback?.Invoke(txt);
                }
                else
                {
                    Callback?.Invoke(null);
                }
            }
        }

    }
}
