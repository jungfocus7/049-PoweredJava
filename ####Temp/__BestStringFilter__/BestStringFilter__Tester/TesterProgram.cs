using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace BestStringFilter__Tester
{
    public static class TesterProgram
    {
        private static readonly List<string> _lstLeft = new List<string>();
        private static readonly List<string> _lstResult = new List<string>();

        public static void Main(string[] args)
        {
            _lstLeft.AddRange(
                new string[]
                {
                    "USER_INFO",
                    "KPOP_ARTIST",
                    "APP_INFO",
                    "APP_DEV_INFO",
                    "APP_SERVER_INFO",
                    "APP_CLIENT_INFO",
                }
            );


            const string tbnm = "KPOP_BEST_WORLD";

            if (BestStringFilter.Callback == null)
            {
                BestStringFilter.Callback = delegate (string rw)
                {
                    if (rw != null)
                    {
                        Console.WriteLine("tbnm: {0}", rw);
                    }
                };
            }

            Console.WriteLine(tbnm);
            while (true)
            {
                string ips = Console.ReadLine();
                if (ips == "exit")
                {
                    break;
                }
                else
                {
                    if (ips.IndexOf(';') > -1)
                    {
                        BestStringFilter.WaveFullScan(tbnm, ips);
                    }
                    else
                    {
                        BestStringFilter.CheckUpInputText(tbnm, ips);
                    }
                }
            }

        }








        //public static void Main(string[] args)
        //{
        //    //BestStringFilter.GetCriticalState("%ABC%");
        //    //BestStringFilter.GetCriticalState("%ABC");
        //    //BestStringFilter.GetCriticalState("ABC%");

        //    //BestStringFilter.GetCriticalState("%A%");
        //    //BestStringFilter.GetCriticalState("%AB");
        //    //BestStringFilter.GetCriticalState("AB%");

        //    //BestStringFilter.GetCriticalState("%A");
        //    //BestStringFilter.GetCriticalState("A%");
        //    //BestStringFilter.GetCriticalState("AB");

        //    const string tbnm = "KPOP_BEST_WORLD";
        //    //BestStringFilter.CheckUpInputText(tbnm, "%KPOP%");
        //    //BestStringFilter.CheckUpInputText(tbnm, "KPO%");
        //    //BestStringFilter.CheckUpInputText(tbnm, "%KPOP");

        //    BestStringFilter.Callback = delegate (string cbt, object ao)
        //    {
        //        if (cbt == BestStringFilter.CbtResult)
        //        {
        //            string tx = ao?.ToString() ?? string.Empty;
        //            Console.WriteLine("tbnm: {0}, {1}", tbnm, tx);
        //        }
        //    };

        //    Console.WriteLine(tbnm);
        //    while (true)
        //    {
        //        string ips = Console.ReadLine();
        //        if (ips == "exit")
        //        {
        //            break;
        //        }
        //        else
        //        {
        //            //bool br = BestStringFilter.CheckUpInputText(tbnm, ips);
        //            //Console.WriteLine("tbnm: {0}, ips: {1}, br: {2}", tbnm, ips, br);
        //            BestStringFilter.WaveFullScan(tbnm, ips);
        //        }
        //    }


        //}









        //public static void Main(string[] args)
        //{
        //    //const string tbnm = "KPOP_WORLD_BEST";
        //    //prCheckMatchText(tbnm, "KP%");

        //    //prGetRecState("%ABC%");
        //    //prGetRecState("%ABC");
        //    //prGetRecState("ABC%");

        //    prGetRecState("%A");
        //    prGetRecState("A%");
        //}


        //private const char _pyp = '%';

        //private const char _pkl = 'l';
        //private const char _pkc = 'c';
        //private const char _pkr = 'r';

        //private static void prGetRecState(string ips)
        //{
        //    if ((ips == null) || (ips.Length == 0)) return;

        //    string rst = string.Empty;

        //    int len = ips.Length;
        //    int fi, ei, pi, qi;
        //    char fc, ec;

        //    if (len > 2)
        //    {
        //        fi = 0; ei = len - 1;
        //        fc = ips[fi]; ec = ips[ei];

        //        if ((fc == _pyp) && (ec == _pyp))
        //        {
        //            pi = fi + 1; qi = ei - pi;
        //            rst = ips.Substring(pi, qi);
        //        }
        //        else if (fc == _pyp)
        //        {
        //            pi = fi + 1; qi = ei;
        //            rst = ips.Substring(pi, qi);
        //        }
        //        else if (ec == _pyp)
        //        {
        //            pi = fi; qi = ei - pi;
        //            rst = ips.Substring(pi, qi);
        //        }
        //    }
        //    else if (len == 2)
        //    {
        //        fi = 0; ei = 1;
        //        fc = ips[fi]; ec = ips[ei];

        //        if (fc == _pyp)
        //        {
        //            pi = fi + 1; qi = ei;
        //            rst = ips.Substring(pi, qi);
        //        }
        //        else if (ec == _pyp)
        //        {
        //            pi = fi; qi = ei - pi;
        //            rst = ips.Substring(pi, qi);
        //        }
        //    }
        //    else if (len == 1)
        //    {
        //        fi = 0;
        //        fc = ips[fi];
        //        if (fc != _pyp)
        //        {
        //            rst = ips;
        //        }
        //    }

        //}

        //private static void prCheckMatchText(string txt, string ips)
        //{
        //    if ((txt == null) || (txt.Length == 0)) return;

        //    int l = txt.Length;
        //    if (l > 2)
        //    {

        //    }
        //    else if (l == 2)
        //    {

        //    }
        //    else if (l == 1)
        //    {

        //    }
        //}
    }
}
