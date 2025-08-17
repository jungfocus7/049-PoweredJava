using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;


namespace NobossIndustryWpf_z.CustomControls
{
    public sealed class DataGridEx31 : DataGrid
    {
        private static void prPrintOut(string msg)
        {
            Debug.WriteLine(msg);
        }

        private static void prWhatBaseInfo(DependencyObject dobj)
        {
            //public static VirtualizationCacheLength GetCacheLength(DependencyObject element);
            //public static VirtualizationCacheLengthUnit GetCacheLengthUnit(DependencyObject element);
            //public static bool GetIsContainerVirtualizable(DependencyObject element);
            //public static bool GetIsVirtualizing(DependencyObject element);
            //public static bool GetIsVirtualizingWhenGrouping(DependencyObject element);
            //public static ScrollUnit GetScrollUnit(DependencyObject element);
            //public static VirtualizationMode GetVirtualizationMode(DependencyObject element);

            var x00 = VirtualizingPanel.GetCacheLength(dobj);
            var x01 = VirtualizingPanel.GetCacheLengthUnit(dobj);
            var x02 = VirtualizingPanel.GetIsContainerVirtualizable(dobj);
            var x03 = VirtualizingPanel.GetIsVirtualizing(dobj);
            var x04 = VirtualizingPanel.GetIsVirtualizingWhenGrouping(dobj);
            var x05 = VirtualizingPanel.GetScrollUnit(dobj);
            var x06 = VirtualizingPanel.GetVirtualizationMode(dobj);
            //prPrintOut(msg);

            //Type tp = typeof(DataGrid);
            //BindingFlags bf = BindingFlags.Public | BindingFlags.Instance | BindingFlags.DeclaredOnly;
            //PropertyInfo[] pia = tp.GetProperties(bf);
            //if ((pia != null) && (pia.Length > 0))
            //{
            //    foreach (PropertyInfo pi in pia)
            //    {
            //        object vo = pi.GetValue(obj);
            //        string vst = vo?.ToString() ?? "null";
            //        string msg = $"{pi.Name}={vst}";
            //        prPrintOut(msg);
            //    }
            //}
        }

        public DataGridEx31()
        {
            prWhatBaseInfo(this);

            SelectionMode = DataGridSelectionMode.Single;
            IsReadOnly = true;
        }
    }
}
